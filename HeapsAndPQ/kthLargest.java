package HeapsAndPQ;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargest {

    //Approach 1: Max Heap = O(NlogN)

    //Approach 2: Min Heap = O(NlogK)
    public int minHeapApproach(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.add(num);
            if(pq.size()>k)
                pq.remove();
        }
        return pq.remove();
    }
}
