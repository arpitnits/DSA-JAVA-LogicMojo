package LinkedList;

public class ReverseInK {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null  || k<=1) return head;

        ListNode curr = head, nxt=null, prev=null;
        int counter=1;
        while(curr!=null && counter<=k) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            counter++;
        }

        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
