package main.recusrsion.string;

public class SayDigits {

    static String[] arr = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static void printDigits(int n){
        if(n == 0)
            return;
        int digit= n%10;
        n = n/10;
        System.out.println(arr[digit]);
        printDigits(n);
    }

    public static void main(String[] args) {
        SayDigits.printDigits(432);
    }
}
