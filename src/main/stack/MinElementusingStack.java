package main.stack;

import java.util.Stack;

public class MinElementusingStack {
    private static Stack<Integer> mainStack = new Stack<>();
    private static Stack<Integer> supportingStack = new Stack<>();

    private static Integer getMin() {
        return supportingStack.peek();
    }

    private static void push(Integer item) {
        if ((supportingStack.isEmpty()) || (item <= supportingStack.peek())) {
            supportingStack.push(item);
        }
        mainStack.push(item);
    }

    private static Integer pop() {
        Integer item = null;
        if (!mainStack.isEmpty()) {
            item = mainStack.pop();
            if (item.equals(supportingStack.peek())) {
                supportingStack.pop();
            }
        }
        return item;
    }

    public static void main(String[] args) {
        MinElementusingStack.push(10);
        MinElementusingStack.push(30);
        MinElementusingStack.push(50);
        MinElementusingStack.push(20);
        MinElementusingStack.push(5);
        //MinElementusingStack.push(80);
        System.out.println(MinElementusingStack.getMin());
        MinElementusingStack.pop();
        System.out.println(MinElementusingStack.getMin());

    }
}
