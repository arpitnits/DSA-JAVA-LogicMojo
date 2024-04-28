package LinkedList;

public class AlternateSplit {

    public void alternatingSplitList(MainLL.Node head){
        MainLL.Node head1, head2, temp, curr=head;
        head1 = head;
        if(head==null || head.next==null) {
            head2 = null;
            return;
        }
        head2 = head.next;
        while(curr.next!=null) {
            temp =curr.next;
            curr.next = curr.next.next;
            curr = temp;
        }
    }
}
