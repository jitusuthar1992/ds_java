package main.string;

public class RotationString {
    public static boolean isRotation(String s1, String s2){
        int l1 = s2.length();
        int l2 = s2.length();

        if(l1 != l2)
            return false;
        String temp = s1 + s2;
        if(temp.contains(s1)){
            return true;
        }
        return false;
    }
}
