package BitManipulation;

public class PlayWithBits {
    public static void getIthBit(int n, int i) {
        if((n & 1<<i) !=0)
            System.out.println("I-th bit is 1");
        else System.out.println("I-th bit is 0");
    }

    public static void setIthBit(int n, int i) {
        System.out.println("After set I-th Bit "+ (n | (1<<i)));
    }

    public static void clearIthBit(int n, int i) {
        System.out.println("After clearing I-th Bit "+ (n & ~(1<<i)));
    }

    public static void checkIfPowerOfTwo(int n) {
        boolean isPowerOfTwo =  (n!=0 && (n  & (n-1)) == 0) ;
        System.out.println("The power of two: " + isPowerOfTwo);
    }

    public static void countSetBits(int n) {
        int counter =0;
        while(n>0) {
            if( (n&1) !=0) counter++;
            n = n>>1;
        }
        System.out.println("Total SetBits: " + counter);
    }


    //O(logN)
    public static int countAllSetBits(int n) {
        if(n==0) return 0;
        int x = findHighestPowerOf2(n); //O(logN)

        return (int)((x*Math.pow(2,x-1)) + //O(1)
                (n-Math.pow(2,x)+1) + //O(1)
                countAllSetBits(n-(int)Math.pow(2,x)));  //O(logN)
    }

    public static int findHighestPowerOf2(int n) {
        int x =0;
        while(1<<x <= n) {
            x++;
        }
        return x-1;
    }
    public static void main(String[] args) {

    }
}
