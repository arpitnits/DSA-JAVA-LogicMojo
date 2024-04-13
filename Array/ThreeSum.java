package Array;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {4,1,2,5,3};
        int N = 5;
        int x = 9;

        Arrays.sort(arr);
        for(int i=0;i<N-2;i++) {

            int l=0,r=arr.length-1,sum=0, target=x-arr[i];

            //TC = O(N)
            while(l<r) {
                sum = arr[l] + arr[r];
                if(sum == target) {
                    System.out.println("Pair found:  "+ arr[i] + " " +arr[l] + " "+ arr[r]);
                    return;
                } else if(sum<target) {
                    l++;
                } else {
                    r--;
                }
            }
            System.out.println("No Pair Found with sum="+target);
        }
    }
}
