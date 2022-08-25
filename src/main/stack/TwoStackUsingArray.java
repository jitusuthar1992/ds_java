package main.stack;

public class TwoStackUsingArray {
    private int top1, top2;
    private int arr[];

    private int pop1() {
        if (top1 == -1)
            return -1;
        return arr[top1--];
    }

    private int pop2() {
        if (top2 == arr.length)
            return -1;
        return arr[top1++];
    }

    private void push1(int x) throws Exception {
        top1++;
        if (top2 == top1)
            throw new Exception("Array Overflow");
        arr[top1] = x;
    }

    private void push2(int x) throws Exception {
        top2++;
        if (top2 == top1)
            throw new Exception("Array Overflow");
        arr[top2] = x;
    }

}
