package dp;

public class CoinChangeProblem {

    static int count(int a[], int n,int m){
        int table[][] = new int[m+1][n+1];
        table[0][0] =1;
        for (int i=1;i<n;i++){
            table [0][i] = 0;
        }
        for (int i=1;i<m+1;i++){
            for (int j = 0; j <n+1 ; j++) {

                    if(i > j){
                        table[i][j] = table[i-1][j];
                    }else{
                        table[i][j] = table[i-1][j] + table[i][j-i];
                    }
                }


        }
        for (int i = 0; i <m+1 ; i++) {
            for (int j=0;j<n+1;j++){
                System.out.print(table[i][j] +" ");
            }
            System.out.println();

        }
        System.out.println(table);
        return table[m][n];
    }
    public static void main(String[] args) {
        int a[] ={1,2,3,4,5};
        System.out.println(count(a,6,5));

    }
}
