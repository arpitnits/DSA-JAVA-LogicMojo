package Array;

import java.util.Arrays;

public class ClosestToZero {

    public static void bruteForce(int[] arr) {
        int n = arr.length, currSum=0;

        int closestSum = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                currSum = arr[i] + arr[j];

                if(Math.abs(currSum)  < Math.abs(closestSum)) {
                    closestSum = currSum;
                }
            }
        }
        System.out.println("Closest Sum to zero is :" + closestSum);

    }


    public static void twoPointerApproach(int[] arr) {
        int n = arr.length, currSum=0;

        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        int l=0,r=n-1;

        while(l<r) {
            currSum = arr[l] + arr[r];

            if(Math.abs(currSum)  < Math.abs(closestSum) ||
                    (Math.abs(currSum)  == Math.abs(closestSum) && closestSum < currSum)) {
                closestSum = currSum;
            }

            if(currSum<0) l++;
            else r--;
        }
        System.out.println("Closest Sum: "+ closestSum);
    }


    public static void main(String[] args) {
        int[] arr = {-2,9,6,1,3,-5};
        bruteForce(arr);
        twoPointerApproach(arr);
    }
}
