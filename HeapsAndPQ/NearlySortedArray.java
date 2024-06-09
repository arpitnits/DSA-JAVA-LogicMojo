package HeapsAndPQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearlySortedArray {

    public List<Integer> nearlySorted(int[] arr, int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        //O(nlogK)
        for(int x : arr)
            pq.add(x); //O(logK)

        for(int i=0;i<n;i++)
            ans.add(pq.poll());

        return ans;
    }
}
