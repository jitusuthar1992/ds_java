package main.array.codelibrary;

public class CountSquares {
    private static int countSquares(int n) {
        int a = (int) Math.sqrt(n);
        if (a * a == n)
            return a - 1;
        return a;
    }

    public static void main(String[] args) {
        System.out.printf("CountSquare = " + countSquares(35));
    }
}
