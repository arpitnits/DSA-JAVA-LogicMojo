package HeapsAndPQ;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallest {

    //Approach 2: Max Heap = O(NlogK)
    public int maxHeapApproach(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max Heap

        for(int num : nums) {
            pq.add(num);
            if(pq.size()>k)
                pq.remove();
        }
        return pq.remove();
    }
}
