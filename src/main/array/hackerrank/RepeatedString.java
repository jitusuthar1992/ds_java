package main.array.hackerrank;

public class RepeatedString {
    static long repeatedString(String s, long n) {

        int count = 0;
        int k = (int) (n / s.length());
        int l = (int) (n % s.length());

        for (char c : s.toCharArray()) {
            if ('a' == c) {
                count++;
            }
        }


        count *= k;

        for (int i = 0; i < l; i++) {
            if ('a' == s.toCharArray()[i]) {
                count++;
            }

        }

        return count;
    }

}
