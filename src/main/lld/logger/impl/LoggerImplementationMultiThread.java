package main.lld.logger.impl;

import main.lld.logger.LogClient;
import main.lld.logger.Process;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoggerImplementationMultiThread implements LogClient {

    private final Map<String, Process> processes;
    //private final ConcurrentSkipListMap<Long, Process> queue;

    private final PriorityQueue<Process> queue;

    private final List<CompletableFuture<Void>> futures;

    private final ExecutorService[] taskScheduler;

    private final Lock lock;

    public LoggerImplementationMultiThread(int n) {
        this.processes = new ConcurrentHashMap<>();
        //this.queue = new ConcurrentSkipListMap<>();
        this.queue = new PriorityQueue<>(Comparator.comparingLong(process -> process.getStartTime()));
        this.futures = new CopyOnWriteArrayList<>();
        this.lock = new ReentrantLock();
        taskScheduler = new ExecutorService[n];
        for (int i = 0; i < n; i++) {
            taskScheduler[i] = Executors.newSingleThreadExecutor();
        }
    }

    @Override
    public void start(String processId) {
        taskScheduler[processId.hashCode() % taskScheduler.length].execute(() -> {
            final Long now = System.currentTimeMillis();
            final Process process = new Process(processId, now);
            processes.put(processId, process);
            queue.add(process);
        });
    }

    @Override
    public void end(String processId) {
        taskScheduler[processId.hashCode() % taskScheduler.length].execute(() -> {
            lock.lock();
            try {
                final Long now = System.currentTimeMillis();
                processes.get(processId).setEndTime(now);

                if (!futures.isEmpty() && queue.peek().getId().equals(processId)) {
                    pollNow();
                    final CompletableFuture result = futures.remove(0);
                    result.complete(null);
                }
            } finally {
                lock.unlock();
            }
        });
    }


    @Override
    public String poll() {
        lock.lock();
        try {
            final CompletableFuture result = new CompletableFuture<Void>();
            if (!queue.isEmpty() && queue.peek().getEndTime() != -1) {
                pollNow();
            } else {
                futures.add(result);
            }
            //wait for end od first process id
            try {
                result.get(3, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    private void pollNow() {
        if (!queue.isEmpty() && queue.peek().getEndTime() != -1) {
            final Process process = queue.peek();
            System.out.println("Process " + process.getId() + " started at " + process.getStartTime() + " ended at " + process.getEndTime());
            processes.remove(process.getId());
            queue.poll();
        }
    }
}

