package LinkedList;

public class MainLL {

    static class Node {
        int data;
        Node next = null;

        Node(int val) {
            this.data = val;
        }
    }

    static class DNode {
        int data;
        Node next = null;
        Node prev = null;

        DNode(int val) {
            this.data = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node head = node1;

        Node node2 = new Node(4);
        node1.next = node2;

        Node node3 = new Node(8);
        node2.next = node3;

        Node node4 = new Node(83);
        node3.next = node4;

        Node node5 = new Node(18);
        node4.next = node5;

        Node node6 = new Node(1);
        node5.next = node6;

        System.out.println(KthNodeFromEnd.KthNodeFromEnd(head, 3).data);
    }
}
