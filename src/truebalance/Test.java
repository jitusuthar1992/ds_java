package truebalance;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Test {

    public static int  countValidWords(String sentence) {
        String[] str = sentence.split(" ");
        int ans =0;
        for(String s:str){
            boolean bool = true;
            int cou =0;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                // Character.isLetter(ch)
                if(ch >= 'a' && ch <= 'z'){
                }
                else if(ch == '-' && i < s.length()-1 && Character.isLetter(s.charAt(i+1)) && i > 0 && Character.isLetter(s.charAt(i-1))){
                    cou++;
                    if(cou > 1){
                        bool = false;
                        break;
                    }
                }
                else if(ch == '.' ||ch == ','||ch == '!'){
                    if(i != s.length()-1){
                        bool = false;
                        break;
                    }
                }
                else{
                    bool = false;
                    break;
                }
            }
            if(bool && s.length() > 0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Test.countValidWords("This is Form16 submission date"));
    }
}
