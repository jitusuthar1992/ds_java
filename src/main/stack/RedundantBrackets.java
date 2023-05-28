package main.stack;

import java.util.Stack;

public class RedundantBrackets {

    public static boolean isRedundantBrackets(char[] input){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];

            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                stack.push(ch);
            }else {
                if(ch == ')'){
                    boolean redundant = true;

                    while (stack.peek() != '('){
                        char top = stack.peek();
                        if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                            redundant = false;
                        }
                        stack.pop();
                    }
                    if(redundant)
                        return true;
                }
            }
        }
        return false;
    }

}
