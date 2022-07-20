package main.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    private Stack<Integer> stack = new Stack<>();

    private void reverse() {
        if (stack.size() > 0) {
            Integer x = stack.peek();
            stack.pop();
            reverse();

            insertAtBottom(x);
        }
    }

    private void insertAtBottom(Integer x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            Integer a = stack.peek();
            stack.pop();
            insertAtBottom(x);

            stack.push(a);

        }
    }

    public static void main(String[] args) {

        ReverseStackUsingRecursion obj = new ReverseStackUsingRecursion();
        obj.stack.push(1);
        obj.stack.push(2);
        obj.stack.push(3);
        obj.stack.push(4);
        for (Integer a : obj.stack) {
            System.out.println(a);
        }
        obj.reverse();

        for (Integer a : obj.stack) {
            System.out.println(a);
        }
    }
}
