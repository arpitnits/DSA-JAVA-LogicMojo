package LinkedList;


public class Intersection {

    public static MainLL.Node findIntersection(MainLL.Node head1, MainLL.Node head2) {

        int n = Operations.findSize(head1);
        int m = Operations.findSize(head2);
        int diff = Math.abs(n-m);
        if(n>m) {
            while(diff>0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            while(diff>0) {
                head2 = head2.next;
                diff--;
            }
        }

        while(head1!=null && head2!=null && head1!=head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1==head2)
            return head1;
        else return null;
    }
}
