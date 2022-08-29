package main.stack;

import java.util.Stack;

public class SortStackWithRecursion {
    private Stack<Integer> stack = new Stack<>();

    private void sort() {
        if (stack.size() > 0) {
            Integer x = stack.peek();
            stack.pop();
            sort();

            insertAtCorrectPosition(x);
        }
    }

    private void insertAtCorrectPosition(Integer x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
        } else {
            Integer a = stack.peek();
            stack.pop();
            insertAtCorrectPosition(x);
            stack.push(a);

        }
    }

    public static void main(String[] args) {

        SortStackWithRecursion obj = new SortStackWithRecursion();
        obj.stack.push(10);
        obj.stack.push(4);
        obj.stack.push(11);
        obj.stack.push(23);
        for (Integer a : obj.stack) {
            System.out.println(a);
        }
        obj.sort();

        System.out.println("");
        for (Integer a : obj.stack) {
            System.out.println(a);
        }
    }
}
