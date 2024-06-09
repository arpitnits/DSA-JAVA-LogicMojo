package HeapsAndPQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkedList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val)) ;

        //Add first Element for each K list
        for(ListNode ls : lists) {
            if(ls!=null) pq.add(ls);
        }


        while(!pq.isEmpty()) {
            ListNode topNode = pq.poll();
            if(head==null)  head=topNode;
            else curr.next = topNode;

            curr = topNode;

            if(topNode.next!=null)
                pq.add(topNode.next);
        }
        return head;
    }
}
