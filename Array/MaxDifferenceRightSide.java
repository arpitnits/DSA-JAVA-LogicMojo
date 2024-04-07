package Array;

public class MaxDifferenceRightSide {


    public  static  void bruteForce(int[] arr) {

        int n = arr.length;

        int maxDiff =0;

        for(int i=0;i<n;i++) {
            for (int j=i+1; j<n;j++) {
                maxDiff = Math.max(maxDiff, arr[j] - arr[i]);
            }
        }
        System.out.println("Max Difference: " + maxDiff);
    }

    public static void optimised(int[] arr) {
        int n = arr.length;
        int minElement = arr[0], maxDiff=0;
        for(int i=1;i<n;i++) {
            maxDiff = Math.max(maxDiff, arr[i] - minElement);
            minElement = Math.min(minElement, arr[i]);
        }
        System.out.println("MAX diff: " + maxDiff);
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,2};
        optimised(arr);
    }
}
