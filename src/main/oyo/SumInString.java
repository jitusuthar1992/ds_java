package main.oyo;

public class SumInString {
    static int findSum(String str) {
        int sum =0;
        String tmp ="";
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch)){
                tmp+=ch;
            }else {
                sum+= Integer.parseInt(tmp);
                tmp ="0";
            }

        }

        return sum+Integer.parseInt(tmp);
    }

    public static void main (String[] args)
    {

        // input alphanumeric string
        String str = "12abc20yz68";

        System.out.println(findSum(str));
    }
}
