package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloningRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null)  return null;

        Map<Node, Node> map = new HashMap<>();

        Node head2 = new Node(head.val);
        map.put(head, head2);
        Node orig = head;
        Node copy = head2;

        orig = orig.next;
        while(orig!=null) {
            Node temp = new Node(orig.val);
            map.put(orig, temp);
            copy.next = temp;
            orig = orig.next;
            copy = copy.next;
        }


        orig = head;
        while (orig!=null) {
            map.get(orig).random = map.get(orig.random);
            orig = orig.next;
        }
        return head2;
    }

    public Node copyRandomListWithoutSpace(Node head) {
        if(head==null)  return null;

        Node curr = head, temp=null;

        //Insert all copy nodes in between
        while(curr!=null) {
            temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        //Update random pointers
        curr = head;
        Node head2 = head.next;
        while(curr!=null && curr.next!=null) {
            if(curr.random!=null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        //Split
        curr= head;
        while(curr!=null && curr.next!=null) {
            temp = curr.next.next;
            if(temp==null)  curr.next.next = null;
            else            curr.next.next = temp.next;
            curr.next = temp;
            curr = curr.next;
        }
        return head2;
    }
}
