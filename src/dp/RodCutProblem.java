package dp;

public class RodCutProblem {
    static int maxProfit(int n, int m[] ,int length,int prices[]){
        int table [][] = new int[length+1][n+1];
        for (int i =0;i<n+1;i++){
            table[0][i] =0;
        }
        for (int i =0;i<length+1;i++){
            table[i][0] =0;
        }



        for (int i =1;i < length+1;i++){
            for (int j =0;j<n+1;j++){
                if( i>j){
                    table[i][j] = table[i-1][j];
                }else{

                    table[i][j] = Math.max(table[i-1][j],prices[i-1]+table[i][j-i]);
                }

            }
        }
        for (int i = 0; i <m.length+1 ; i++) {
            for (int j=0;j<n+1;j++){
                System.out.print(table[i][j] +" ");
            }
            System.out.println();

        }
        return table[length][n];
    }

    public static void main(String[] args) {
        int m[] ={1,2,3,4,5};
        int prices[] = {1,5,4,3,9};
        System.out.println(maxProfit(7,m,5,prices));
    }

}
