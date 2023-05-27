package main.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NearestCell1Distance {
    public static int [][] findDistance(int arr[][]){
        int r = arr.length;
        int c = arr[0].length;

        int ans[][] = new int[r][c];
        Queue<RottenEgg.Pair> queue = new LinkedList<>();
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(arr[i][j] == 1){
                    ans[i][j] = 0;
                    queue.offer(new RottenEgg.Pair(i,j));
                }else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()){
            int first = queue.peek().first;
            int second = queue.peek().second;

            if((first-1) >= 0 && ans[first][second]+1 < ans[first-1][second]){
                ans[first-1][second] = ans[first][second]+1;
                queue.offer(new RottenEgg.Pair(first-1,second));
            }


            if((second-1) >= 0 && ans[first][second]+1 < ans[first][second-1]){
                ans[first][second-1] = ans[first][second]+1;
                queue.offer(new RottenEgg.Pair(first,second-1));
            }

            if((first+1) < r && ans[first][second]+1 < ans[first+1][second]){
                ans[first+1][second] = ans[first][second]+1;
                queue.offer(new RottenEgg.Pair(first+1,second));
            }


            if((second+1) < c && ans[first][second]+1 < ans[first][second+1]){
                ans[first][second+1] = ans[first][second]+1;
                queue.offer(new RottenEgg.Pair(first,second+1));
            }
            queue.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] ={
                {1,0,1},
                {1,1,0},
                {1,0,0}
        }   ;
        int ans[][] = NearestCell1Distance.findDistance(arr);
        int r = ans.length;
        int c = ans[0].length;

        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
