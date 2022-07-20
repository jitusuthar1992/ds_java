package main.array;

public class KthDigit {
    public static double nthDigit(double n) {

        if (n < 10) {
            return n;
        }


        int k = 0;
        double first = 9;
        double last = 0;
        double orig = n;
        while (n > 0) {
            k++;
            n -= 9 * Math.pow(10, k - 1) * k + first;

        }

        if (k == 2) {
            orig -= first;

        } else {
            orig -= 9 * Math.pow(10, k - 1) * k + first;
        }

        if (orig % k == 0) {
            return ((orig / k) - 1) % Math.pow(10, k - 1);
        }
        return orig % k;


    }

    public static double nDigit(double n) {


        int k = 0;
        //double first =9;double last=0;double orig =n;
        while (n > 0) {
            k++;
            n -= 9 * Math.pow(10, k - 1) * k;

        }

        n += 9 * Math.pow(10, k - 1) * k;
        if (n % k == 0) {

            return (Math.pow(10, k - 1) + (n / k) - 1) % 10;
        } else {
            //int finalNumber = ;
            return ((Math.pow(10, k - 1) + (n / k) / Math.pow(10, k - (n % k)))) % 10;
        }


    }

    public static void main(String[] args) {
        System.out.println(nDigit(146));

    }
}
