package main.dp;

public class FibonacciWithMemoized {
    final int MAX = 100;
    final int NIL = -1;
    int lookup[] = new int[MAX];

    void initialize() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }

    int fib(int n) {

        if (lookup[n] == NIL) {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fib(n - 1) + fib(n - 2);
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        FibonacciWithMemoized f = new FibonacciWithMemoized();
        int n = 4;
        f.initialize();
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }
}
