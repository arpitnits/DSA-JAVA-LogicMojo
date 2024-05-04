package LinkedList;

public class MergeTwoSortedLL {

public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
}

