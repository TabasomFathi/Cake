
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int t = scanner.nextInt();
        long p = scanner.nextLong();
        int zero=0;
        int[] ni = new int[t];
        int[] mi = new int[t];
        for (int i = 0; i <t ; i++) {
            int n = scanner.nextInt();
            ni[i]=n;
            if (n>zero){
                zero=n;
            }
            int m = scanner.nextInt();
            mi[i]=m;

        }
        long [] factorial=new long[zero+1];
        long [] inverse = new long[zero+1];
        factorial[0]=1;
        for (int i = 0; i <=zero ; i++) {
            if(i>0){
                long s= factorial[i - 1] *i;
                s=s%p;
                if (s<0)
                    s=s+p;
                factorial [i] =s;

            }
            inverse[i] = inverse(factorial[i],p);
        }

        for (int i = 0; i <t ; i++) {
            int n = ni[i];
            int m = mi[i];
            long result=0;
            if (n==m || m==0) {
                result = 1;
            }else if (n==p){
                result=0;
            }
            else {
                result = (factorial[n] * inverse[m])%p;
                if(result<0)
                    result=result+p;
                result=result*inverse[n - m];
                result = result % p;
                if (result < 0) {
                    result = result + p;
                }
            }
            System.out.println(result);
        }

    }
    //    static int factorial(int x, int p) {
//        int res =1;
//        if (x==0){
//            return 1;
//        }
//        for (int i = 1; i <=x ; i++) {
//            res *= i;
//            res=res%p;
//
//        }
//        return res;
//
//
//    }
    static  long inverse(long n,long p){
        if (n==1){
            return 1;
        }
        long a = 0;
        long b = p;
        long u = 1;
        long m = n;
        while (m>0){
            long q = b / m;
            long r = b % m;
            if(r<0)
                r=r+m;
            long c = a;
            long d=m;
            m = r;
            a = u;
            b = d;
            long s=q *u;
            s=s%p;
            if (s<0)
                s=s+p;
            u = c-s;

        }
        a=a%p;
        if (a>0)
            return a;
        else
            return a+p;
//        return a%p;
    }

    static long x;
    static long y;

    static long gcdEuclid(long a,long b){
        if (a==0){
            x=0;
            y=1;
            return b;
        }
        long r=b%a;
        long q=b/a;
        if (r<0)
            r=r+a;
        long d=gcdEuclid(b%a,a);
        long tempX=x;
        x=y-q*x;
        y=tempX;
        return d;

    }
    static long inverse2(long n,long p){
        x=0;y=1;
        long d=gcdEuclid(n,p);
        x=x%p;
        if(x<0)
            x=x+p;
        return x;
    }
}