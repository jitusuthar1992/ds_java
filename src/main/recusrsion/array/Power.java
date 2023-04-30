package main.recusrsion.array;

public class Power {
    int power(int a, int b){
        if(b ==0)
            return 1;
        if(b == 1)
            return a;
        int ans = power(a,b/2);
        if(b%2 ==0){
            return ans*ans;
        }else {
            return a*ans*ans;
        }
    }


    int fastPower(int a , int b){
        int res = 1;
        while (b > 0){
            if((b&1) != 0){
                res = res * a;
            }
            a = a*a ;
            b = b >> 1;
        }
        return res;
    }

    /*
     (a*b)%n = (a%n *b%n) %n
     (a+b)%n = (a%n +b%n) %n
     */
    long powerUsingModuloOpr(long a , long b , int n){
        long res = 1;
        while (b > 0){
            if((b&1) != 0){
                res = (res * a % n)%n;
            }
            a = (a % n * a%n) %n ;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("2^10 = "+new Power().powerUsingModuloOpr(2,10,1000000007));
    }
}
