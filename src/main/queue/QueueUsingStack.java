package main.queue;

import java.util.Stack;

/**
 * @author jitendra.kumar01
 * 01/02/20
 */
public class QueueUsingStack<T> {
    private Stack<T> s1;
    private Stack<T> s2;

    public QueueUsingStack(Stack<T> s1, Stack<T> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void enQueue(T data){
        s1.push(data);
    }

    public T deQueue(){
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
