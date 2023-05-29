package main.stack;

import java.util.Stack;

public class MaxAreaInBinaryMatrix {


    public int maxAreaBinaryMatrix(int matrix[][]){
        int area = maxArea(matrix[0]);
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(matrix[i][j] != 0){
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j];
                }else {
                    matrix[i][j] =0;
                }
            }
            area = Math.max(area,maxArea(matrix[i]));
        }
        return area;
    }
    public int maxArea(int input[]) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < input.length; ) {
            if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                area = input[top] * (stack.isEmpty() ? i :(i - stack.peek() - 1));
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            area = input[top] * (stack.isEmpty() ? i :(i - stack.peek() - 1));
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
     /*   MaxHistogramArea mh = new MaxHistogramArea();
        int input[] = {1, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2};
        int maxArea = mh.maxHistogram(input);
        System.out.println(maxArea);*/

        int arr[][] ={
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}

        };
        MaxAreaInBinaryMatrix mh = new MaxAreaInBinaryMatrix();
        System.out.println(mh.maxAreaBinaryMatrix(arr));

    }
}
