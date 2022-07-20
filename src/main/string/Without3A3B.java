package main.string;

import java.util.Optional;

public class Without3A3B {
    public static String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L - 1) == ans.charAt(L - 2)) {
                if (ans.charAt(L - 1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(3, 3));

        System.out.println(Optional.ofNullable(null).orElse(0.0));

        for (int i = 0; i < 10; i++) {

            try {
                if (i == 1) {
                    throw new RuntimeException();

                }
                System.out.println("s" + i);

            } catch (Exception e) {
                System.out.println("NULL");
            }

        }
    }
}
