package LinkedList;

public class MiddleinLL {

    public static MainLL.Node middleNode(MainLL.Node head) {
        MainLL.Node slow = head, fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
