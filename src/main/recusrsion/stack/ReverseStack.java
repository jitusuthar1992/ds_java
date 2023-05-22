package main.recusrsion.stack;

import java.util.Stack;

public class ReverseStack {
    static Stack<Character> stack  = new Stack<>();

    static void reverse(){
        if(stack.size() > 0){
            char x = stack.peek();
            stack.pop();
            reverse();
            insertAtBottom(x);
        }
    }

    private static void insertAtBottom(char x) {
        if(stack.empty())
            stack.push(x);
        else {
            char a = stack.peek();
            stack.pop();
            insertAtBottom(x);
            stack.push(a);
        }
    }

    public static void main(String[] args) {
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');
        System.out.println(stack);
        ReverseStack.reverse();
        System.out.println(stack);

    }
}
