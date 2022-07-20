package main.stack;

import java.util.Stack;

public class MinStackAuxiliarySpace {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> auxStack = new Stack<>();
    public void push(int val){
        if(stack.isEmpty()){
            auxStack.push(val);
        }else {
            int top = auxStack.peek();
            if(val < top){
                auxStack.push(val);
            }
        }
        stack.push(val);
    }

    public int pop(){
        if (stack.empty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }
        int top = auxStack.peek();
        int popElm = stack.pop();

        if(top == popElm){
            auxStack.pop();
        }
        return popElm;
    }
    public int getMin() {
        return auxStack.peek();
    }
    public static void main (String[] args)
    {
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
