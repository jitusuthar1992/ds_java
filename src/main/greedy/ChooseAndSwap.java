package main.greedy;

import java.util.Set;
import java.util.TreeSet;

public class ChooseAndSwap {
    private char[] getLexString(String str){

        char[] chars = str.toCharArray();
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i <chars.length ; i++) {
            set.add(chars[i]);
        }
        for (int i = 0; i <chars.length ; i++) {
            set.remove(chars[i]);
            if(set.isEmpty())
                break;
            Character ch = set.stream().findFirst().get();
            if(ch < chars[i]){
                Character ch1 = chars[i];
                for (int j = 0; j < chars.length; j++) {
                    if(chars[j] == ch)
                        chars[j] = ch1;
                    else if (chars[j] == ch1)
                        chars[j] = ch;
                }
                break;
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(new ChooseAndSwap().getLexString("ccad"));
        System.out.println(new ChooseAndSwap().getLexString("abba"));
    }
}
