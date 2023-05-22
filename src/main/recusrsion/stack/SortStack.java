package main.recusrsion.stack;

import java.util.Stack;

public class SortStack {
    static Stack<Integer> stack  = new Stack<>();

    static void sort(){
        if(stack.size() > 0){
            int x = stack.peek();
            stack.pop();
           sort();
            insertAtCorrectPosition(x);
        }
    }

    private static void insertAtCorrectPosition(int x) {
        if(stack.empty() || stack.peek() < x)
            stack.push(x);
        else {
            int a = stack.peek();
            stack.pop();
            insertAtCorrectPosition(x);
            stack.push(a);
        }
    }

    public static void main(String[] args) {
        stack.push(14);
        stack.push(15);
        stack.push(11);
        stack.push(18);
        System.out.println(stack);
        SortStack.sort();
        System.out.println(stack);

    }
}
