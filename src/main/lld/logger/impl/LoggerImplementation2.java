package main.lld.logger.impl;

import main.lld.logger.LogClient;
import main.lld.logger.Process;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LoggerImplementation2 implements LogClient {

    Map<String, Process> processes ;
    TreeMap<Long,Process> queue;

    public LoggerImplementation2() {
        this.processes = new HashMap<>();
        this.queue = new TreeMap<>(Comparator.comparingLong(startTime -> startTime));
    }

    @Override
    public void start(String processId) {
        final Long now = System.currentTimeMillis();
        final Process process = new Process(processId,now);
        processes.put(processId,process);
        queue.put(now,process);
    }

    @Override
    public void end(String processId) {
        final Long now = System.currentTimeMillis();
        processes.get(processId).setEndTime(now);
    }

    @Override
    public String poll() {
        if(queue.isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        final  Process process = queue.firstEntry().getValue();
        if(process.getEndTime() != -1){
            System.out.println("Process "+process.getId()+ " started at "+process.getStartTime() + " ended at "+process.getEndTime());
            processes.remove(process.getId());
            queue.pollFirstEntry();
        }else {
            System.out.println("No Completed Task in the queue ."+ queue.size());
        }
        return null;
    }
}
