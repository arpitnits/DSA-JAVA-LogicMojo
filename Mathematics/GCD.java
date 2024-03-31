package Mathematics;

import java.util.Arrays;

public class GCD {

    public static void findGCD(int a, int b) {
        int minVal = Math.min(a, b);
        while(minVal>0) {
            if(a%minVal == 0 && b%minVal == 0) {
                System.out.println("GCD Found: " + minVal);
                return;
            }
            minVal--;
        }
    }

    public static int findGCDRecursive(int a, int b) {
        if(b==0)
            return a;
        return findGCDRecursive(b, a%b);
    }
    public static void findGCDEuclidean(int a, int b) {
        int gcd=0;
        if(a<b) {
            gcd = findGCDRecursive(b, a);
        } else {
            gcd = findGCDRecursive(a, b);
        }
        System.out.println("GCD Found: " + gcd);
    }

    public static void isPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i == 0) {
                System.out.println(n + " is not prime");
                return;
            }
        }
        System.out.println(n + " is prime");
    }

    public static int seiveOfErathosthenes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j=i*i; j<=n; j=j+i) {
                    prime[j] = false;
                }
            }
        }

        int count =0;
        for(int i=2;i<n;i++) {
            if(prime[i]) count++;
        }
        return count;
    }

    public static void NthFibonnaci(int n) {
        int a = 0;
        int b = 1;
        for(int i=2;i<n;i++) {
            b = a+b;
            a = b-a;
        }
        System.out.println("Fibonnaci number " + b);
    }

    public static void main(String[] args) {
    }
}
