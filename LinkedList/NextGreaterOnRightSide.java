package LinkedList;

import java.util.Stack;

public class NextGreaterOnRightSide {

    //TC = O(N)
    //SC = O(N)
    public int[] nextGreater(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;

        int[] nextGreater = new int[n];

       for(int i=0;i<n;i++) {
           while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
               nextGreater[s.peek()] = nums[i];
               s.pop();
           }
           s.push(i); //index
       }
       return nextGreater;
    }
}
