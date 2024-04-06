package Array;

public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {1,2,4,6,3,7,8};
        int N = 8;

        int ans = 0;
        for(int i=0;i<N-1;i++) {
            ans = ans^arr[i];
        }

        for(int i=1;i<=N;i++) {
            ans = ans^i;
        }
        System.out.println("Missing Value: " + ans);
    }
}
