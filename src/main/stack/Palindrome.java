package main.stack;

import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(String inputStr) {
        int i = 0, j = inputStr.length();
        char[] A = inputStr.toCharArray();
        while (i < j && A[i] == A[j]) {
            i++;
            j--;
        }
        if (i < j)
            return false;
        return true;
    }

    //using Stack
    public boolean isPalindromeStack(String inputStr) {
        int i = 0;
        char[] input = inputStr.toCharArray();
        Stack stack = new Stack();
        while (input[i] != 'X') {
            stack.push(input[i]);
            i++;
        }
        i++;
        while (i < inputStr.length()) {
            if (stack.isEmpty())
                return false;
            if (stack.pop().equals(input[i]))
                return false;
            i++;
        }
        return true;
    }


}
