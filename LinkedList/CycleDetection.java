package LinkedList;

public class CycleDetection {

    public static MainLL.Node findCycle(MainLL.Node head) {

        MainLL.Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)
                return slow;
        }
        return null;
    }
}
