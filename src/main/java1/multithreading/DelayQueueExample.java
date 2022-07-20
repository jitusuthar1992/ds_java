package main.java1.multithreading;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jitendra.kumar01
 * 31/12/19
 */
public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DelayQueue<DelayedEvent> queue = new DelayQueue<>();
        AtomicInteger counter = new AtomicInteger();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new DelayedEventProducer(queue, counter), 1, 2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new DelayedEventConsumer(queue), 1, 10, TimeUnit.SECONDS);
    }
}

class DelayedEvent implements Delayed {

    private long id;
    private String name;
    private LocalDateTime activationDateTime;

    public DelayedEvent(long id, String name, LocalDateTime activationDateTime) {
        super();
        this.id = id;
        this.name = name;
        this.activationDateTime = activationDateTime;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getActivationDateTime() {
        return activationDateTime;
    }

    @Override
    public int compareTo(Delayed that) {
        long result = this.getDelay(TimeUnit.NANOSECONDS)
                - that.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        LocalDateTime now = LocalDateTime.now();
        long diff = now.until(activationDateTime, ChronoUnit.MILLIS);
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "DelayedEvent [id=" + id + ", name=" + name + ", activationDateTime=" + activationDateTime + "]";
    }
}

class DelayedEventProducer implements Runnable {
    private final DelayQueue<DelayedEvent> queue;
    private AtomicInteger counter;

    public DelayedEventProducer(DelayQueue<DelayedEvent> queue, AtomicInteger counter) {
        this.queue = queue;
        this.counter = counter;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        int id = counter.incrementAndGet();
        DelayedEvent event = new DelayedEvent(id, "Task-" + id, now);
        System.out.println("Added to queue :: " + event);
        queue.add(event);
    }
}

class DelayedEventConsumer implements Runnable {
    private final DelayQueue<DelayedEvent> queue;

    public DelayedEventConsumer(DelayQueue<DelayedEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        List<DelayedEvent> events = new ArrayList<DelayedEvent>();
        queue.drainTo(events);
        System.out.println("\nEvent processing start **********\n");
        events.stream().forEach(System.out::println);
        System.out.println("\nEvent processing end **********\n");
    }
}