package main.string;

public class FirstIndexOfSubString {

    public static int getIndex(String subString, String mainString) {
        int strLen = mainString.length();
        int subStrLen = subString.length();
        int index = -1, j = 0;
        if (strLen < 1) {
            return index;
        }

        for (int i = 0; i < strLen; i++) {
            if (mainString.charAt(i) == subString.charAt(j)) {
                index = i - j;
                j++;
                if (j == subStrLen) {
                    return index;
                }
            } else {
                index = -1;
                j = 0;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(getIndex("test", "main-1test"));
    }
}

