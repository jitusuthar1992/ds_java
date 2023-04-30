package main.recusrsion.string;

public class PowerSet {

    public static void powerSet(String str , int i, String curr){
        if(i == str.length()){
            if(curr ==""){
                curr = "EMPTY";
            }
            System.out.println(curr);
            return;
        }
        powerSet(str,i+1,curr+str.charAt(i));
        powerSet(str,i+1,curr);
    }

    public static void main(String[] args) {
        PowerSet.powerSet("abc",0,"");
    }
}
