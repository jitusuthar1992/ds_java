package main.string;

public class ShuffleString {

    private static boolean isShuffleString(String s1 , String s2 , String res){
        int resl = res.length() , s1l = s1.length() , s2l = s1.length();
        if(s1l+s2l != resl)
            return false;
        else {
            int k =0 ,i=0,j=0;
            while (k < resl){
                if(i<s1l && s1.charAt(i) == res.charAt(k))
                    i++;
                else if (j<s2l && s2.charAt(j) == res.charAt(k))
                    j++;
                else
                    break;
                k++;
            }
            if (i<s1l || j<s2l)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Shuffle String : "+ ShuffleString.isShuffleString("xy","12","x1y2"));
    }
}
