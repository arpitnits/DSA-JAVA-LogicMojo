package LinkedList;

public class Operations {

    static class Node {
        int data;
        Node next = null;

        Node(int val) {
            this.data = val;
        }
    }

    public static void iterateTraversal(Node head) {

        while (head!=null) {
            System.out.print(head.data+ "->");
            head = head.next;
        }
    }

    public static void recursiveTraversal(Node head) {
        if(head==null)
            return;

        System.out.print(head.data + "->");
        recursiveTraversal(head.next);
    }

    public static void insertAtBeginning(Node head, int Val) {
        System.out.println("Before insertion: ");
        iterateTraversal(head);

        Node newNode = new Node(Val);

        newNode.next = head;
        head = newNode;

        System.out.println("\nAfter insertion: ");
        iterateTraversal(head);
    }

    public static void insertAtEnd(Node head, int Val) {
        System.out.println("Before insertion: ");
        iterateTraversal(head);

        Node tempNode = head;
        while(tempNode.next!=null) {
            tempNode = tempNode.next;
        }
        tempNode.next = new Node(Val);

        System.out.println("\nAfter insertion: ");
        iterateTraversal(head);
    }

    public static Node search(Node head, int target) {
        while(head!=null) {
            if(head.data == target) {
                System.out.println("Found Value");
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static int findSize(Node head, int target) {
        int count=0;
        while(head!=null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static Node deleteKey(Node head, int key) {

        if(head!=null && head.data==key) {
            head = head.next;
            return head;
        }
        Node curr = head;
        Node prev = null;

        while (curr!=null && curr.data!=key) {
            prev = curr;
            curr = curr.next;
        }

        if(curr==null) {
            System.out.println("Not found");
        }

        prev.next = curr.next;
        return head;
    }

    public static Node reverseRecursive(Node curr, Node prev) {
        if(curr==null) {
            return prev;
        }

        Node nxt = curr.next;
        curr.next = prev;

        return reverseRecursive(nxt, curr);
    }

    public static Node reverseIterative(Node head) {
        Node curr = head;
        Node prev = null, nxt = null;

        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;

        return head;
    }

    public static void main(String[] args) {
        // 2->4->8
        Node node1 = new Node(2);
        Node head = node1;

        Node node2 = new Node(4);
        node1.next = node2;

        Node node3 = new Node(8);
        node2.next = node3;


        head = reverseIterative(head);
        iterateTraversal(head);

    }
}
