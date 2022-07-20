package main.oyo;

public class CheckPerfectSquare {

    static boolean isPerfectSquare(double x) {
        double sr = Math.sqrt(x);

        return (sr - Math.floor(sr) == 0);
    }

    public static void main(String[] args) {
        double x = 2500;

        if (isPerfectSquare1(x))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    static boolean isPerfectSquare1(double x) {
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0 && (x / i == i)) {
                return true;
            }
        }
        return false;
    }
}
