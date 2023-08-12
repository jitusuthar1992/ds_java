package main.lld.ratelimiter.slidingwindow;

import main.lld.ratelimiter.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindow implements RateLimiter {
    Queue<Long> slidingWindow;
    int timeWindowInSeconds;
    int bucketCapacity;

    public SlidingWindow(int timeWindowInSeconds, int bucketCapacity) {
        this.slidingWindow = new ConcurrentLinkedDeque<>();
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.bucketCapacity = bucketCapacity;
    }

    @Override
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if(this.slidingWindow.size() < bucketCapacity){
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdateQueue(long currentTime) {
        if(slidingWindow.isEmpty())
            return;
        long calculatedTime = (currentTime - slidingWindow.peek())/1000;
        while (calculatedTime >=  timeWindowInSeconds){
            slidingWindow.poll();
            if(slidingWindow.isEmpty())
                break;
            calculatedTime = (currentTime - slidingWindow.peek())/1000;
        }
    }
}
