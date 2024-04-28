package LinkedList;

public class PalindromicLL {

    public MainLL.Node findMiddle(MainLL.Node head) {
        MainLL.Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public MainLL.Node reverse(MainLL.Node head) {
        MainLL.Node curr = head;
        MainLL.Node prev = null, nxt = null;

        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;

        return head;
    }

    public boolean isPalindrome( MainLL.Node head) {
        MainLL.Node mid = findMiddle(head);
        MainLL.Node firstHalf = head;
        MainLL.Node secondHalf = reverse(mid);

        while(firstHalf!=mid) {
            if(firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}
