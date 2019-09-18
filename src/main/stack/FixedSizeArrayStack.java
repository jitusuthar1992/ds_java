package main.stack;

import java.util.Stack;

public class FixedSizeArrayStack<T extends Object> {
    //length of the main.array used to implement the main.stack
    protected int capacity;
    //Default main.array capacity
    public static final int CAPACITY =10;
    //main.array used to implement main.stack
    protected T[] stackRep;
    //index of the top element of the main.stack in main.array;
    protected int top=-1;
    //initializes the main.stack to use an main.array of default length

    public FixedSizeArrayStack() {
    }

    //initializes the main.stack to use an main.array of given length
    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stackRep = (T[])new Object[capacity];
    }

    //return no of element in a main.stack

    public int size(){
        return (top+1);
    }

    //test whether main.stack is empty
    public boolean isEmpty(){
        return (top<0);
    }
    //inserts an element at the top of the main.stack
    public void push(T data) throws Exception{
        if(size() == capacity)
            throw new Exception("Stack is Full");
        stackRep[top++] = data;
    }

    //remove element from the top

    public  T pop() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty");
        T data = stackRep[top];
        //stackRep[top--]= Integer.MIN_VALUE;
        return data;
    }



}

