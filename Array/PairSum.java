package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    public static void twoPointerApproach(int[] arr, int target) {
        Arrays.sort(arr); //O(NlogN)
        int l=0,r=arr.length-1, sum=0;

        //TC = O(N)
        while(l<r) {
            sum = arr[l] + arr[r];
            if(sum == target) {
                System.out.println("Pair found:  "+ arr[l] + " "+ arr[r]);
                return;
            } else if(sum<target) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("No Pair Found with sum="+target);
    }

    public static void hashMapApproach(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: arr) {
            if(map.containsKey(target-x)) {
                System.out.println("Pair Found: " + x + " " + (target-x));
                return;
            }
            map.put(x, 1);
        }
        System.out.println("No Pair found");
    }


    public static void main(String[] args) {
        int[] arr = {3,1,4,10,2};
        twoPointerApproach(arr, 4);
    }
}
