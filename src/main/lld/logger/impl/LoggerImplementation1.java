package main.lld.logger.impl;

import main.lld.logger.LogClient;
import main.lld.logger.Process;

import java.util.TreeMap;

public class LoggerImplementation1 implements LogClient {

    TreeMap<String, Process> processMap;

    public LoggerImplementation1(TreeMap<String, Process> processMap) {
        this.processMap = processMap;
    }

    @Override
    public void start(String processId) {
        processMap.put(processId, new Process(processId, System.currentTimeMillis()));
    }

    @Override
    public void end(String processId) {
        processMap.get(processId).setEndTime(System.currentTimeMillis());
    }

    @Override
    public String poll() {
        final Process process = processMap.firstEntry().getValue();
        if (process.getEndTime() != -1) {
            System.out.println("Process " + process.getId() + " started at " + process.getStartTime() + " ended at " + process.getEndTime());
            processMap.remove(process.getId());
        }
        return null;
    }
}
