package main.array;

public class CelebrityProblem {

    private static int getCelibrity(int arr[][]){
        int c =0;

        for (int i = 1; i <arr.length ; i++) {
            if(arr[c][i] ==1){
                c =i;
            }
        }

        for (int i = 0; i < arr.length ; i++) {
            if(i !=c && (arr[c][i]==1 || arr[i][c]==0)){
                return -1;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {0, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.printf("Celebrity is " + getCelibrity(arr));
    }
}
