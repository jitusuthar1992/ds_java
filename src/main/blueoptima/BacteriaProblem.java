package main.blueoptima;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BacteriaProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Rows: ");
        int m = sc.nextInt();
        System.out.println("Number of Columns: ");
        int n = sc.nextInt();
        int[][] input = new int[m][n];
        input[m - 1][0] = 1;
        Stack<String> stack = new Stack<>();
        stack.push(m - 1 + "~" + 0);
        reproduce(stack, input, n-1);

        System.out.println("Value at Bottom Right corner after "+ (n-1) + " secs: " + input[m - 1][n - 1]);
    }

    private static void reproduce(Stack<String> stack, int[][] input, int times) {
        //exit condition
        if (times < 1) {
            return;
        }

        //bacteria after splitting
        List<String> children = new ArrayList<>();

        //reproduce all existing bacteria
        while (!stack.isEmpty()) {
            String[] coordinates = stack.pop().split("~");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);


            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    split(input, x + i, y + j, children);
                }
            }
            input[x][y]--;
        }

        //add all children to stack
        for (String coord : children) {
            stack.push(coord);
        }

        //reduce times by 1
        reproduce(stack, input, times - 1);

    }

    private static void split(int[][] input, int x, int y, List<String> children) {
        int m = input.length;
        int n = input[0].length;

        if (x >= 0 && x < m && y >= 0 && y < n) {
            input[x][y]++;
            children.add(x + "~" + y);
        }
    }
}

//https://stackoverflow.com/questions/55784115/programming-puzzle-how-to-count-number-of-bacteria-that-are-alive
