package main.string;

public class MinFlips {
    public static int minFlips(String s){
        int c1=0,c2=0;
        for (int i = 0; i < s.length(); i++) {
            if((i&1) !=0 && s.charAt(i) == '0'){
                c1++;
            }
            if((i&1) ==0 && s.charAt(i) == '1'){
                c1++;
            }
            if((i&1) !=0 && s.charAt(i) == '1'){
                c2++;
            }
            if((i&1) ==0 && s.charAt(i) == '0'){
                c2++;
            }
        }
        return Math.min(c1,c2);
    }
}
