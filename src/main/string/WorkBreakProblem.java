package main.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkBreakProblem {
    private static Map<String,Integer> map = new HashMap<>();
    private static boolean isWordBreak(String word , List<String> input){
        int x = isSolve(word,input);
        if(x ==1)
            return true;
        return false;
    }

    private static int isSolve(String word, List<String> input) {
        int sz = word.length();
        if(sz==0)
            return 1;
        if(null != map.get(word) && 1 == map.get(word))
            return 1;
        for (int i = 1; i <=sz ; i++) {
            String ss = word.substring(0,i);
            int f =0;
            for (int j = 0; j <input.size() ; j++) {
                if(input.contains(ss)){
                    f=1;
                    break;
                }
            }
            if(f==1 && isSolve(word.substring(i,sz-i),input)==1){
                map.put(word,1);
                return 1;
            }

        }
        map.put(word,-1);
        return -1;
    }
}
