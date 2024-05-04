package LinkedList;

public class MergeSort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.val<=l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode curr = head;
        while(l1!=null && l2!=null) {
            if(l1.val<=l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while(l1!=null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }

        while(l2!=null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return head;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)   return head;

        ListNode mid = middleNode(head);
        ListNode midNxt = mid.next;
        mid.next = null;

        //break into 2 halves
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(midNxt);

        //merge
        return mergeTwoLists(firstHalf, secondHalf);
    }

}
