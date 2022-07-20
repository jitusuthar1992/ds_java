package main.systemdesign.loadbalancer.impl;

import main.systemdesign.loadbalancer.LoadBalancer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancer extends LoadBalancer {
    private int counter = 0;
    private ReentrantLock lock;

    public RoundRobinLoadBalancer(List<String> ipList) {
        super(ipList);
        lock = new ReentrantLock();
    }

    @Override
    protected String getIp() {
        lock.lock();

        try {
            String ip = ipList.get(counter);
            counter++;
            if (counter == ipList.size()) {
                counter = 0;
            }
            return ip;
        } finally {
            lock.unlock();
        }
    }
}
