package main.stack;

import java.util.Stack;

//get minimium from a main.stack with complexity O(1)
/*
create a auxiliary main.stack that maintains minimium of all values in the main.stack
when we pop the main.stack, pop the minStack too.
when we push the main main.stack , push either the new element or the current minimium
 */

public class GetMinimiumUsingStack {
    private Stack elementStack = new Stack();
    private Stack minStack = new Stack();

    public void pushSol1(int data){
        elementStack.push(data);
        if(minStack.isEmpty() || (Integer)minStack.peek()>= (Integer)data ){
            minStack.push(data);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public Object popsol1(){
        if(elementStack.isEmpty())
            return null;
        minStack.pop();
        return  elementStack.pop();
    }

    public Object getMinimium(){
        return minStack.peek();
    }


    public void pushSol2(int data){
        elementStack.push(data);
        if(minStack.isEmpty() || (Integer)minStack.peek()>= (Integer)data )
            minStack.push(data);
    }

    public Object popsol2(){
        if(elementStack.isEmpty())
            return null;
        int minTop = (Integer) minStack.peek();
        int element = (Integer) elementStack.peek();
        if(minTop == element)
            minStack.pop();

        return  elementStack.pop();
    }
}
