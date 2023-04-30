package main.recusrsion.array;

public class NthStairProblem {

    public static int countWays(int n){
        if(n < 0)
            return 0;
        if(n ==0){
            return 1;
        }
        return countWays(n-1)+ countWays(n-2);
    }

    public static void main(String[] args) {
        System.out.println("No of ways :"+NthStairProblem.countWays(3));
    }
}
