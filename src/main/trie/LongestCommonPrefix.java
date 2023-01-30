package main.trie;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    private String getLongestCommonPrefix(List<String> inputs){
        String ans = "";
        for (int i = 0; i <inputs.get(0).length() ; i++) {
            char ch = inputs.get(0).charAt(i);
            boolean match = true;

            for (int j = 1; j <inputs.size() ; j++) {
                //not match
                if(inputs.get(j).length()< i || ch != inputs.get(j).charAt(i)){
                    match= false;
                    break;
                }
            }
            if(match == false)
                break;
            else
               ans=  ans.concat(String.valueOf(ch))  ;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("coding","coders","codingninza","codezer");
        System.out.println("LongestCommonPrefix :"+new LongestCommonPrefix().getLongestCommonPrefix(inputs));
    }
}
