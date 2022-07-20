package main.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack();
    private int min;

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else if (val > min) {
            stack.push(val);
        } else {
            stack.push(2 * val - min);
            min = val;
        }
    }

    public int pop() {
        if (stack.empty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }
        int top = stack.peek();
        if (top < min) {
            min = 2 * min - top;
        }
        return stack.pop();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        s.push(6);
        System.out.println(s.getMin());

        s.push(7);
        System.out.println(s.getMin());

        s.push(5);
        System.out.println(s.getMin());

        s.push(3);
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());
    }
}
