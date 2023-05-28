package main.stack;

import java.util.Stack;

public class MinCostValidExp {
    public static int minCost(char[] input){
        if((input.length &1) !=0){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];
            if(ch == '('){
                stack.push(ch);
            }else {
                if(!stack.isEmpty() && stack.peek() == ')'){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }
        int a = 0,b=0;
        while (!stack.isEmpty()){
            char ch = stack.peek();
            if(ch == '('){
                a++;
            }else {
                b++;
            }
            stack.pop();
        }
        return ((a+1)/2)+((b+1)/2);
    }
}
