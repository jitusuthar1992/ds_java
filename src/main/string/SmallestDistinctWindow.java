package main.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindow {
    public static int smallestWindowLength(char[] input){
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (char ch: input) {
            set.add(ch);
        }

        int n = 4, c =0 ,i =0,j=0;

        int minIndex = 0 ,maxIndex=0;
        int ans = Integer.MAX_VALUE;
        while (i<=j && j< input.length){
            if(c<n){
                int count =map.getOrDefault(input[j],0);
                if(count==0)
                    c++;
                map.put(input[j],count+1);
                j++;
            }else if(c == n){
                if(j-i < ans){
                    ans = j-i;;
                    minIndex = i;
                    maxIndex = j;
                }
                //ans = Math.min(ans,j-i);
                int count =map.getOrDefault(input[i],0);
                if(count ==1){
                    c--;
                }
                map.put(input[i],count-1);
                i++;
            }
        }

        while(c == n){
            if(j-i < ans){
                ans = j-i;;
                minIndex = i;
                maxIndex = j;
            }
            //ans = Math.min(ans,j-i);
            int count =map.getOrDefault(input[i],0);
            if(count ==1){
                c--;
            }
            map.put(input[i],count-1);
            i++;
        }

        System.out.println(String.valueOf(input).substring(minIndex,maxIndex));
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println("Smallest window containing all distinct"
                + " characters is " + SmallestDistinctWindow.smallestWindowLength(str.toCharArray()));
    }
}
