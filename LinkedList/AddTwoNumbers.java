package LinkedList;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseIterative(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, nxt = null;

        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;

        return head;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseIterative(l1);
        l2 = reverseIterative(l2);

        int rem =0, sum, value;
        ListNode head=null, curr=null;

        while (l1!=null && l2!=null) {
            sum = l1.val + l2.val + rem;
            value = sum%10;
            rem = sum/10;
            if(head==null) {
                head = new ListNode(value);
                curr = head;
            } else {
                curr.next = new ListNode(value);
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null) {
            sum = l1.val + rem;
            value = sum%10;
            rem = sum/10;
            curr.next = new ListNode(value);
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2!=null) {
            sum = l2.val + rem;
            value = sum%10;
            rem = sum/10;
            curr.next = new ListNode(value);
            curr = curr.next;
            l2 = l2.next;
        }

        if(rem!=0) {
            curr.next = new ListNode(rem);
        }

        return reverseIterative(head);
    }
}
