package main.lld.ratelimiter.leackybucket;

import main.lld.ratelimiter.RateLimiter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeackyBucket implements RateLimiter {
    BlockingQueue<Integer> blockingQueue;

    public LeackyBucket(int capacity) {
        this.blockingQueue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public boolean grantAccess() {
        if(this.blockingQueue.remainingCapacity()>0){
            this.blockingQueue.add(1);
            return true;
        }
        return false;
    }
}
