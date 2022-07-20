package main.string;

public class PrintReverseWord {

    static void reverseWord(String s) {
        String[] sr = s.split(" ");
        String rev = "";
        for (int i = 0; i < sr.length; i++) {
            if (i == sr.length - 1) {
                rev = sr[i] + rev;
            } else {
                rev = " " + sr[i] + rev;
            }
        }
        System.out.println(rev);
    }

    public static void main(String[] args) {
        String s = "I am Geek";
        System.out.println(s);
        reverseWord(s);
    }
}
