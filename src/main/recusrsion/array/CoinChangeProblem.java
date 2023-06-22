package main.recusrsion.array;

public class CoinChangeProblem {
    static int count(int coins[],int m,int sum){
        if(sum ==0){
            return 1;
        }

        if(m ==-1 && sum > 0){
            return 0;
        }
        if(sum < 0){
            return 0;
        }
        return count(coins,m,sum-coins[m])+count(coins,m-1,sum);
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        System.out.println(CoinChangeProblem.count(a, 2, 4));
    }
}
