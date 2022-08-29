package main.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    Queue<Integer> q1 = new LinkedList<>();

    public void push(Integer val) {
        q1.offer(val);
        int sz = q1.size()-1;
        while (sz--> 0){
            q1.add(q1.peek());
            q1.poll();
        }
    }

    public Integer pop(){
        if(q1.isEmpty()){
            return -1;
        }
        int ans = q1.peek();
        q1.poll();
        return ans;
    }

}
