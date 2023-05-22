package main.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenEgg {

    public static void main(String[] args) {
        int arr[][] ={
                        {1,0,2},
                        {0,1,2},
                        {1,1,1}
                     }   ;
        System.out.println("No of Seconds "+RottenEgg.noOfSeconds(arr));
    }
    public static int noOfSeconds(int arr[][]){
        int r = arr.length;
        int c = arr[0].length;
        Queue<Pair> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(arr[i][j]  ==2){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        queue.offer(new Pair(-1,-1));
        while (!queue.isEmpty()){
            int i = queue.peek().first;
            int j = queue.peek().second;
            if(i == -1 && j == -1 && queue.size() ==1){
                queue.poll();
                break;
            } else if (i == -1 && j == -1 && queue.size() > 1) {
                count++;
                queue.poll();
                queue.offer(new Pair(-1,-1));
            }else {
                if((i-1)>= 0 && arr[i-1][j]==1){
                    arr[i-1][j]=2;
                    queue.offer(new Pair(i-1,j));
                }

                if((i+1) < r && arr[i+1][j]==1){
                    arr[i+1][j]=2;
                    queue.offer(new Pair(i+1,j));
                }

                if((j-1)>= 0 && arr[i][j-1]==1){
                    arr[i][j-1]=2;
                    queue.offer(new Pair(i,j-1));
                }
                if((j+1) < c && arr[i][j+1]==1){
                    arr[i][j+1]=2;
                    queue.offer(new Pair(i,j+1));
                }
                queue.poll();
            }

        }

        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(arr[i][j]  ==1){
                    return -1;
                }
            }
        }
        return count;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
