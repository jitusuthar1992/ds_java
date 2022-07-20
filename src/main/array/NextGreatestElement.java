package main.array;

import java.util.Stack;

public class NextGreatestElement {
    private void sol1(int nums[]) {
        int n = nums.length;
        int next;

        for (int i = 0; i < n; i++) {
            next = -1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    next = nums[j];
                    break;
                }
            }
            System.out.printf(nums[i] + " -> " + next);
        }
    }

    private void sol2(int nums[]) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            int current = nums[i];

            if (!s.isEmpty() && s.peek() < current) {
                while (!s.isEmpty() && s.peek() < current) {
                    System.out.println(s.pop() + "->" + current);
                }
            }
            s.push(current);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + "-> -1");
        }
    }

    public static void main(String[] args) {
        int nums[] = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};
        new NextGreatestElement().sol2(nums);
    }
}
