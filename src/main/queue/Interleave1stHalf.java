package main.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Interleave1stHalf {
    public static void printFirstHalf(Queue<Integer> queue,int n  ){
        if(queue.isEmpty())
            return;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n/2 ; i++) {
            stack.push(queue.peek());
            queue.poll();
        }

        System.out.println("Stack 1"+stack);
        for (int i = 0; i < n/2 ; i++) {
            queue.offer(stack.peek());
            stack.pop();
        }

        System.out.println("Queue 1"+queue);

        for (int i = 0; i < n-(n/2) ; i++) {
            queue.offer(queue.peek());
            queue.poll();
        }

        System.out.println("Queue 2"+queue);

        for (int i = 0; i < n/2 ; i++) {
            stack.push(queue.peek());
            queue.poll();
        }
        System.out.println("Stack 2"+stack);

        while (!stack.empty()){
            queue.offer(stack.peek());
            stack.pop();
            queue.offer(queue.peek());
            queue.poll();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        Interleave1stHalf.printFirstHalf(queue ,4);
    }
}
