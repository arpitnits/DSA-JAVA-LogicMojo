package LinkedList;

public class FirstNodeinCycle {

    public static MainLL.Node findFirst(MainLL.Node head) {
        MainLL.Node pos = CycleDetection.findCycle(head);

        MainLL.Node entry = head;

        while(entry!=pos) {
            entry = entry.next;
            pos = pos.next;
        }
        return entry;
    }
}
