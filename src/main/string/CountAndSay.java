package main.string;

public class CountAndSay {
    private static String countAndSay(int n){
        if( n==1 )
            return "1";
        if( n==2 )
            return "11";
        String s = "11";
        for (int i = 3; i <=n ; i++) {
            String t = "";
            s = s.concat("$");
            int c =1 ;
            for (int j = 1; j <s.length() ; j++) {
                if(s.charAt(j) != s.charAt(j-1)){
                    t = t.concat(String.valueOf(c));
                    t = t.concat(String.valueOf(s.charAt(j-1)));
                    c =1;
                }else
                    c++;
            }
            s = t;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(CountAndSay.countAndSay(10));
    }
}
