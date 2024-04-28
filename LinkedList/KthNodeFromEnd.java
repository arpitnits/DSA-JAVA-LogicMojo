package LinkedList;

public class KthNodeFromEnd {

    public static MainLL.Node KthNodeFromEnd(MainLL.Node head, int k) {


        MainLL.Node slow = head, fast = head;

        int i=0;

        while(i<k && fast!=null) {
            fast = fast.next;
            i++;
        }

        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
