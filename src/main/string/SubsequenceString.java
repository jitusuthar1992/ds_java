package main.string;

public class SubsequenceString {
    private static void printSubsequence(String t ,int start,int end , String input){
        if(start == end){
            System.out.println(t);
        }else {
            printSubsequence(t,start+1,end,input);
            t = t+input.charAt(start);
            printSubsequence(t,start+1,end,input);
        }
    }

    public static void main(String[] args) {
        String input ="abc";
        SubsequenceString.printSubsequence("",0,input.length(),input);
    }
}
