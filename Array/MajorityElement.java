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
    public static void main(String[] args) {
        int[] arr = {8,5,5,8,2,5,5,5};
        hashMapApproach(arr);
    }
}
