package LinkedList;

public class KthNode {

    public static MainLL.Node getKthNode(MainLL.Node head, int k) {
        MainLL.Node curr =head;

        while(curr!=null && k>1) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
