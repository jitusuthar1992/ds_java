package main.lld.ratelimiter.tokenbucket;

import main.lld.ratelimiter.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {

    private int bucketCapacity;
    private int refreshRate;
    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        this.currentCapacity.getAndSet(bucketCapacity);
        this.lastUpdatedTime.getAndSet(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {
        refreshBucket();
        if(this.currentCapacity.get() > 0){
            this.currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refreshBucket() {
        long currentTime = System.currentTimeMillis();
        int additionalToken = (int) (((currentTime-this.lastUpdatedTime.get())/1000)*refreshRate);
        int currentCap = Math.min(currentCapacity.get()+additionalToken,this.bucketCapacity);
        currentCapacity.getAndSet(currentCap);
        lastUpdatedTime.getAndSet(currentTime);
    }
}
