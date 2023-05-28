package main.stack;

import java.util.Stack;

public class DeleteMiddleElement {
    static void solve(Stack<Integer> stack, int count, int size){
        if(count == size/2){
            stack.pop();
            return;
        }
        int num = stack.peek();
        stack.pop();

        solve(stack,count+1,size);

        stack.push(num);
    }

    public static void deleteMiddleElement(Stack<Integer> stack, int size){
        int count = 0;
        solve(stack,count,size);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(6);
        deleteMiddleElement(stack, stack.size());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
