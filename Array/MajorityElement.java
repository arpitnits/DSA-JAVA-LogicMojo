package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void hashMapApproach(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) +1);

            if(map.get(x) > arr.length/2) {
                System.out.println("Majority found: "+ x);
                return;
            }
        }
    }


    public static void mooreVotingAlgorithm(int[] arr) {
        int maj=arr[0], count=1;
        for(int x : arr) {
            if(x==maj) {
                count++;
            } else {
                count--;
            }
            if(count<0) {
                maj = x;
                count = 1;
            }
        }
        count = 0;
        for (int x : arr) {
            if(maj==x) count++;
        }
        if(count>arr.length/2)
            System.out.println("Majority Element found: " + maj);
        else
            System.out.println("No majority element exist");
    }



    public static void main(String[] args) {
        int[] arr = {5,2,5,8,5,2,5,5};
        mooreVotingAlgorithm(arr);
    }
}
