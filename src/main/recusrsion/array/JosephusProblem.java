package main.recusrsion.array;

public class JosephusProblem {

    public static int findWinner(int n, int k){
        if(n==1)
            return 0;

        return (findWinner(n-1,k)+k)%n;
    }

    public static void main(String[] args) {
        System.out.println("Winner is at position :"+JosephusProblem.findWinner(5,3));
    }
}
