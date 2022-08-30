package main.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueRecursion {
    private static void reverseRecur(Queue<Integer> queue ){
        if (!queue.isEmpty()){
            int x = queue.peek();
            queue.poll();
            reverseRecur(queue);
            queue.offer(x);
        }
    }
    private static void reverse(Queue<Integer> queue ){
        reverseRecur(queue);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println("Before Queue "+queue);
        reverse(queue);
        System.out.println("After Queue "+queue);
    }
}
