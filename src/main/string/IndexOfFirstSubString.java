package main.string;

/**
 * @author jitendra.kumar01
 * 24/02/20
 */
public class IndexOfFirstSubString {
    public static int findFirstIndex(String string , String subString){
        int strLen = string.length();
        int subStrLen = subString.length();
        int j =0 , index =-1;
        if(strLen < 1 ){
            return index;
        }
        for (int i = 0; i <strLen ; i++) {
            if(string.charAt(i) == subString.charAt(j)){
                index = i-j;
                j++;
                if(j == subStrLen){
                    return index;
                }
            }else{
                index =-1;
                j =0;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int index = findFirstIndex("Test happy","app");
        System.out.println(index);
    }
}
