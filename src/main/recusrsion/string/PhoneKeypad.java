package main.recusrsion.string;

import java.util.ArrayList;

public class PhoneKeypad {
    public static void solve(ArrayList<String> ans, String digits, String op , int index,String[] mappings){
        if(index >= digits.length()){
            ans.add(op);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String mapping = mappings[digit];
        for (int i = 0; i <mapping.length() ; i++) {
            String newOp = op.concat(String.valueOf(mapping.charAt(i)));
            solve(ans,digits,newOp,index+1,mappings);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        String op = "";
        String[] mappings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(ans,"23",op,0,mappings);
        System.out.println(ans);
    }
}
