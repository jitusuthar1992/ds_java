package main.lld.ratelimiter.leackybucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer,LeackyBucket> buckets;

    public UserBucketCreator(int id) {
        this.buckets = new HashMap<>();
        this.buckets.put(id,new LeackyBucket(10));
    }

    public void accessApplication(int id){
        if(this.buckets.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
