package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class maxSlidingWindow {

    // nums = [1,3,-1,-3,5,3,6,7], k = 3
    //        [0,1,2, 3, 4,5,6,7]
    // deque = [4]
    //
    public int[] maxSlidingWindow(int[] nums, int k) {
        //remove out of window
        //remove smaller elements


        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length, i=0;
        int[] maxWindow = new int[n-k+1];

        while (i<k) {
            while (!d.isEmpty() && nums[d.getLast()] <= nums[i]) {
                d.removeLast();
            }
            d.addLast(i);
            i++;
        }

        int j=0;
        while (i<n) {
            maxWindow[j++] = nums[d.getFirst()];

            //remove out of window
            while(!d.isEmpty() && d.getFirst()<=i-k) {
                d.removeFirst();
            }

            //remove smaller element on left side from deque
            while (!d.isEmpty() && nums[d.getLast()] <= nums[i]) {
                d.removeLast();
            }
            d.addLast(i);
            i++;
        }
        maxWindow[j] = nums[d.getFirst()];
        return maxWindow;
    }
}
