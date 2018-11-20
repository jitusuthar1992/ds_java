package stack;

public class FixedSizeArrayStack<T extends Object> {
    //length of the array used to implement the stack
    protected int capacity;
    //Default array capacity
    public static final int CAPACITY =10;
    //array used to implement stack
    protected T[] stackRep;
    //index of the top element of the stack in array;
    protected int top=-1;
    //initializes the stack to use an array of default length

    public FixedSizeArrayStack() {
    }

    //initializes the stack to use an array of given length
    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stackRep = (T[])new Object[capacity];
    }

    //return no of element in a stack

    public int size(){
        return (top+1);
    }

    //test whether stack is empty
    public boolean isEmpty(){
        return (top<0);
    }
    //inserts an element at the top of the stack
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

