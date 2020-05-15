package main.string;

public class LengthWithoutLengthFunction {

    public static int  getLengthSol1(String str){


        int i =0 ;
        try{
            for ( i = 0;; i++) {
                str.charAt(i);
            }
        }catch (StringIndexOutOfBoundsException e){

        }

        return i;

    }

    public static int  getLengthSol2(String str){

        int length =0 ;
        for (char c : str.toCharArray()){
            length++;
        }

        return length;

    }

    public static void main(String[] args) {
        System.out.println("Length :"+ getLengthSol2("AAKASH"));
    }
}
