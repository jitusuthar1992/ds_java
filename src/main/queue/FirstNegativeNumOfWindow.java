package main.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumOfWindow {
    Queue<Integer>  q1 = new LinkedList<>();

    private void firstNegativeNumOfWindow(int k, int arr[]){

        for (int i = 0; i < k-1; i++) {
            if(arr[i] < 0)  {
                q1.add(arr[i]);
            }
        }

        for (int i = k-1; i <arr.length ; i++) {
            if(arr[i] < 0)  {
                q1.add(arr[i]);
            }
             if(!q1.isEmpty()){
                 System.out.println(q1.peek());
                 if(q1.peek()== arr[i -k+1]){
                     q1.poll();
                 }
             }else {
                 System.out.println("0");
             }
        }
    }

    public static void main(String[] args) {
        int arr[] = {-8,2,3,-6,10};
        new FirstNegativeNumOfWindow().firstNegativeNumOfWindow(2,arr);
    }
}
