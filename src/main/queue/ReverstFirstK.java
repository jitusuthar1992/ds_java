package main.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverstFirstK {
    void reverseFirstK(Deque<Integer> queue , int k){
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <=k ; i++) {
            int x = queue.getFirst();
            stack.push(x);
            queue.removeFirst();
        }
        while (!stack.isEmpty()) {
            int x = stack.peek();
            queue.addLast(x);
            stack.pop();
        }

        for (int i = 1; i <= queue.size()-k ; i++) {
            int x = queue.getFirst();
            queue.removeFirst();
            queue.addLast(x);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("Before Queue "+queue);
        new ReverstFirstK().reverseFirstK(queue,2);
        System.out.println("After Queue "+queue);
    }
}
