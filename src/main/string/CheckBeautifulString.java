package main.string;

public class CheckBeautifulString {
    static boolean checkString (String str){

        char first = str.charAt(0);
        StringBuilder tmp =new StringBuilder();
        tmp.append(first)   ;

        int countFirst= 1;
        int lastFirstIndex =0 ;
        for (int i = 1; i <str.length() ; i++) {
            if(str.charAt(i) == first){
                lastFirstIndex =i;
                countFirst++;
                tmp.append(first);
            }
            else{
               break;
            }
        }

        System.out.println(tmp.toString());
        if(str.length() - tmp.length() < tmp.length() +1){
            return false;
        }
        int j =lastFirstIndex+1;
        StringBuilder sb = null;
        while (j < str.length()  ){
            sb = new StringBuilder();

            while (j<=  lastFirstIndex+(countFirst+1) && j < str.length())   {
                             sb.append(str.charAt(j));
                              j++;

            }                                         


            if(Integer.parseInt(String.valueOf(sb)) != Integer.parseInt(String.valueOf(tmp))+1){
                return false;
            }
            lastFirstIndex += countFirst+1;
            tmp = sb;
        }

        return true;
    }

    public static void main(String[] args) {
        if(checkString("91011")){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
