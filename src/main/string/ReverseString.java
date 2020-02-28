package main.string;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author jitendra.kumar01
 * 02/02/20
 */
public class ReverseString {
    public static void main(String[] args) {
        String input = "Java technology blog for smart java concepts and coding practices";
        String reverseWord = reverseWordSol2(input);
        System.out.println(reverseWord);
        reverseWords(reverseWord);

    }


    public static  String reverseWordSol1(String input){
        StringBuilder reverseString = new StringBuilder();

        Stack<String> stack = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(input," ");
        while (tokenizer.hasMoreElements()){
            stack.push(tokenizer.nextToken());
        }

        while (!stack.isEmpty()){
            reverseString.append(stack.pop() +" " );
        }

        System.out.println("Reverse String :"+reverseString.toString() );
        return reverseString.toString();
    }

    public static  String reverseWordSol2(String input){
        char[] temparray = input.toCharArray();
        int left, right=0;
        right = temparray.length-1;

        for (left=0; left < right ; left++ ,right--)
        {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right]=temp;
        }
        return String.valueOf(temparray);
    }

    public static  String reverseWords(String input){
        char[] tempArray = input.toCharArray();
        StringBuilder reverseStr = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <tempArray.length ; i++) {
            stringBuilder.append(tempArray[i]);
            if(tempArray[i] == ' ' || i == tempArray.length-1){
                String tmp = reverseWordSol2(stringBuilder.toString());
                if(i == tempArray.length-1){
                    reverseStr.append(" ");

                }
                reverseStr.append(tmp);
                stringBuilder = new StringBuilder();
            }
        }
        System.out.println(reverseStr.toString());
        return reverseStr.toString();
    }
}
