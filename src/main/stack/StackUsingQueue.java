package main.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(Integer val) {
        q1.add(val);
    }

    public Integer pop() {
        if (q1.isEmpty())
            return -1;
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }

        int val = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return val;

    }

    public static void main(String[] args) {
        StackUsingQueue a = new StackUsingQueue();

        a.push(7);
        a.push(3);
        a.push(4);

        System.out.println(a.pop());
        System.out.println(a.pop());

        a.push(5);

        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }

}
