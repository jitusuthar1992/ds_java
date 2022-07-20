package main.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jitendra.kumar01
 * 13/11/19
 */
public class RemoveDuplicatesString {


    //without ordering
    static String removeDuplicates(String str) {
        char[] arr = str.toCharArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    static String removeDupsSorted(String str) {
        int res_ind = 1, ip_ind = 1;

        // Character array for removal of duplicate characters
        char arr[] = str.toCharArray();

        /* In place removal of duplicate characters*/
        while (ip_ind != arr.length) {
            if (arr[ip_ind] != arr[ip_ind - 1]) {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;

        }

        str = new String(arr);
        return str.substring(0, res_ind);
    }


    public static void main(String[] args) {
        String str = "geeksforgeeks";
        //System.out.println(removeDuplicates(str));
        System.out.println(removeDupsSorted(str));

    }
}
