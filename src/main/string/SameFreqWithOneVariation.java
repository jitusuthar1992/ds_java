package main.string;

public class SameFreqWithOneVariation {
    static int chars = 26;

    static boolean checkVariation(String str) {
        if (str.isEmpty() || str == null) {
            return true;
        }

        int freq[] = new int[chars];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }


        int freq1 = 0, count_freq1 = 0, freq2 = 0, count_freq2 = 0;

        for (int i = 0; i < chars; i++) {
            if (freq[i] == 0)
                continue;
            if (freq1 == 0) {
                freq1 = freq[i];
                count_freq1++;
                continue;
            }
            if (freq[i] == freq1) {
                count_freq1++;
                continue;
            }

            if (freq2 == 0) {
                freq2 = freq[i];
                count_freq2++;
                continue;
            }
            if (freq[i] == freq2) {
                count_freq2++;
                continue;
            }

            return false;

        }

        if (count_freq1 > 1 && count_freq2 > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabbccc";

        if (checkVariation(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
