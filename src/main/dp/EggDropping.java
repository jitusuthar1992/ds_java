package main.dp;

public class EggDropping {
    static int calculate(int eggs , int floors){
        int[][] temp =new int[eggs+1][floors+1];

        int res =0;


        for (int i = 0; i <eggs+1 ; i++) {
            temp[i][0] = 0;
        }
        for (int i = 0; i <floors+1 ; i++) {
            temp[0][i] = 0;
        }

        for(int i=1; i <= floors; i++){
            temp[1][i] = i;
        }
        for (int i = 2; i <=eggs ; i++) {
            for (int j = 1; j <=floors ; j++) {
                if(i > j){
                    temp[i][j] = temp[i-1][j];
                }else{
                     temp[i][j] = Integer.MAX_VALUE;

                    for (int k = 1; k <=j ; k++) {
                        res = 1+ Math.max(temp[i-1][k-1],temp[i][j-k]);
                        if(res < temp[i][j]){
                            temp[i][j] = res;
                        }

                    }
                }
            }
        }

        return temp[eggs][floors];

    }

    public static void  main(String args[] )
    {
        int n = 2, k = 36;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                                   " floors is "+calculate(n, k));
    }
}
