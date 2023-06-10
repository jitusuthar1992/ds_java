package main.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorpicString {
    private static boolean  isIsomorphic(String s1 , String s2){
        int n1 = s1.length(),n2 = s2.length();
        if(n1 != n2)
            return false;
        Map<Character,Character> m1 = new HashMap<>();
        Map<Character,Character> m2 = new HashMap<>();
        for (int i = 0; i <s1.length() ; i++) {
            if(!m1.containsKey(s1.charAt(i)) && !m2.containsKey(s2.charAt(i)) ){
                m1.put(s1.charAt(i),s2.charAt(i));
                m2.put(s2.charAt(i),s1.charAt(i));
            } else if (m1.get(s1.charAt(i))!= s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Isomorpihic : "+IsomorpicString.isIsomorphic("abaab","xyxxy"));
    }
}
