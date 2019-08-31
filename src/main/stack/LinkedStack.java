package main.stack;

import main.linkedlist.singly.ListNode;

public class LinkedStack<T> {
    private int length;
    private ListNode top;

    public LinkedStack() {
        length =0;
        top = null;
    }

    //add specified data to the top of this main.stack
    public  void push(int data){
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public boolean isEmpty(){
        return (null ==top);
    }
    //remove the data at the top of the main.stack

    public int pop() throws Exception {
        if(isEmpty())
            throw new Exception("Stack is Empty");
        int data= top.getData();
        top = top.getNext();
        length--;
        return data;
    }

    public int size(){
        return length;
    }
}
