package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {


    public static void generateAllSubsets(int[] nums, List<Integer> subSet, int index, int target) {

        if(target==0) {
            System.out.println(subSet);
            return;
        }

        if(target<0 || index==nums.length) {
            return;
        }

        //notTake
        generateAllSubsets(nums, subSet, index+1, target);

        //take
        subSet.add(nums[index]);
        generateAllSubsets(nums, subSet, index+1, target-nums[index]);
        subSet.remove(subSet.size()-1);

    }


    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 5;

        generateAllSubsets(arr, new ArrayList<>(), 0, target);
    }
}
