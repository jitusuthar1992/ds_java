package main.recusrsion.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RateInMaze {

    public static ArrayList<String> findPath(int arr[][], int m , int n){
        ArrayList<String> ans = new ArrayList<>();
        String path = "";
        int x =0, y=0;

        int visited[][]= new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                visited[i][j] = 0;
            }
        }

        solve(ans,path,arr,visited,x,y,m,n);
        Collections.sort(ans,Comparator.naturalOrder());
        return ans;
    }

    private static void solve(ArrayList<String> ans,String path , int[][] arr, int[][] visited, int x, int y, int m, int n) {
        if(x == m-1 && y == n-1){
            ans.add(path);
            return;
        }

        visited[x][y] =1;

        // D,L,R,U

        int newX = x+1;
        int newY = y;

        if(isSafe(arr,visited,newX,newY,m,n)){
            String newPath = path + "D";
            solve(ans,newPath,arr,visited,newX,newY,m,n);
        }

         newX = x;
         newY = y-1;

        if(isSafe(arr,visited,newX,newY,m,n)){
            String newPath = path + "L";
            solve(ans,newPath,arr,visited,newX,newY,m,n);
        }

        newX = x;
        newY = y+1;

        if(isSafe(arr,visited,newX,newY,m,n)){
            String newPath = path + "R";
            solve(ans,newPath,arr,visited,newX,newY,m,n);
        }

        newX = x-1;
        newY = y;

        if(isSafe(arr,visited,newX,newY,m,n)){
            String newPath = path + "U";
            solve(ans,newPath,arr,visited,newX,newY,m,n);
        }
        visited[x][y] =0;
    }

    private static boolean isSafe(int[][] arr, int[][] visited, int newX, int newY, int m, int n) {
        if(newX <= m-1 && newX >= 0 && newY <= m-1 && newY >= 0 && arr[newX][newY] ==1 && visited[newX][newY] == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        System.out.println(findPath(maze,4,4));
    }
}
