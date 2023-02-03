package main.recusrsion;

public class ReverseString {
    static void reverse(char[] chars,int i, int j){
        if(i > j)
            return;
        swap(chars,i,j);
        i++;
        j--;

        reverse(chars,i,j);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp ;
        temp = chars[i] ;
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'J','I','T'};
        ReverseString.reverse(chars,0,chars.length-1);
        System.out.println("reverse string "+String.valueOf(chars));
    }
}
