package LinkedList;

public class Operations {

    

    public static void iterateTraversal(MainLL.Node head) {

        while (head!=null) {
            System.out.print(head.data+ "->");
            head = head.next;
        }
    }

    public static void recursiveTraversal(MainLL.Node head) {
        if(head==null)
            return;

        System.out.print(head.data + "->");
        recursiveTraversal(head.next);
    }

    public static void insertAtBeginning(MainLL.Node head, int Val) {
        System.out.println("Before insertion: ");
        iterateTraversal(head);

        MainLL.Node newNode = new MainLL.Node(Val);

        newNode.next = head;
        head = newNode;

        System.out.println("\nAfter insertion: ");
        iterateTraversal(head);
    }

    public static void insertAtEnd(MainLL.Node head, int Val) {
        System.out.println("Before insertion: ");
        iterateTraversal(head);

        MainLL.Node tempNode = head;
        while(tempNode.next!=null) {
            tempNode = tempNode.next;
        }
        tempNode.next = new MainLL.Node(Val);

        System.out.println("\nAfter insertion: ");
        iterateTraversal(head);
    }

    public static MainLL.Node search(MainLL.Node head, int target) {
        while(head!=null) {
            if(head.data == target) {
                System.out.println("Found Value");
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static int findSize(MainLL.Node head) {
        int count=0;
        while(head!=null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static MainLL.Node deleteKey(MainLL.Node head, int key) {

        if(head!=null && head.data==key) {
            head = head.next;
            return head;
        }
        MainLL.Node curr = head;
        MainLL.Node prev = null;

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

    public static MainLL.Node reverseRecursive(MainLL.Node curr, MainLL.Node prev) {
        if(curr==null) {
            return prev;
        }

        MainLL.Node nxt = curr.next;
        curr.next = prev;

        return reverseRecursive(nxt, curr);
    }

    public static MainLL.Node reverseIterative(MainLL.Node head) {
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

    public static void main(String[] args) {
        // 2->4->8
        

    }
}
