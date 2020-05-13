package main.array;

import java.util.Arrays;

public class SortLargeNumbers {

    public static void sort(String arr[]){
        Arrays.sort(arr,(left,right)->{
            if(left.length() != right.length())
                return left.length() - right.length();
            return left.compareTo(right);
        });
    }

    public static void main(String args[])
    {
        String arr[] = {"5", "1237637463746732323",
                "97987", "12" };
        sort(arr);
        for (String s : arr)
            System.out.print(s + " ");
    }
}
