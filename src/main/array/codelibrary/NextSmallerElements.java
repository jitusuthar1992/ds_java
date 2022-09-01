package main.array.codelibrary;

import java.util.Stack;

public class NextSmallerElements {
    void nextSmallerElements(int arr[]){
        Stack<Node> s = new Stack<>();
        int[] ans = new int[arr.length];

        s.push(new Node(arr[0],0));
        for (int i = 1; i <arr.length ; i++) {
            while (!s.isEmpty() && s.peek().value > arr[i]){
                ans[s.peek().index] = arr[i];
                s.pop();
            }
            s.push(new Node(arr[i],i));
        }

        while (!s.isEmpty()){
            ans[s.peek().index] = -1;
            s.pop();
        }
        System.out.println("Next Smaller Elements are :");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " : "+ ans[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,8,5,2,25};
        new NextSmallerElements().nextSmallerElements(arr);
    }

    class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
