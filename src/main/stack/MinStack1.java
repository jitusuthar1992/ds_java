package main.stack;

import java.util.Stack;

public class MinStack1 {
    private Stack<Integer> s1 = new Stack();
    private Stack<Integer> s2 = new Stack();
    private int min = Integer.MAX_VALUE;

    public void push(int val) {
        s1.push(val);
        if (val < min) {
            min = val;
            s2.push(min);
        }
    }

    public int pop() {
        if (s1.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
        int val = s1.pop();
        if (val == s2.peek()) {
            s2.pop();
            min = s2.peek();
        }
        return val;
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
