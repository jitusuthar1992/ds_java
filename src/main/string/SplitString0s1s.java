package main.string;

/*
Split the binary string into substrings
with equal number of 0s and 1s
*/

public class SplitString0s1s {
    private static int getCount(String s){
        int n = s.length();
        int x = 0 , y=0 , c=0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0')
                x++;
            else
                y++;
            if(x==y)
                c++;
        }
        if(x !=y)
            return -1;
        return c;
    }
}
