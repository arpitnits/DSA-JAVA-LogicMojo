package Queue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value =value;
            this.prev = null;
            this.next = null;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    private int capacity = 5;
    Node head=null, tail =null;

    public void put(int key, int value) {
        Node temp;
        if(map.containsKey(key)) {
            temp = map.get(key);
            temp.value = value;
            moveToHead(temp);
        } else {
            if(map.size()>=capacity) {
                removeTail();
            }
            temp = new Node(key,value);
            map.put(key, temp);
            addToHead(temp);
        }
    }

    private void removeTail() {
        if(tail.prev!=null)     tail.prev.next=null;
        else head = null;

        map.remove(tail.key);
        tail = tail.prev;
    }

    private void moveToHead(Node temp) {
        if(temp==head) return;
        if(temp==tail)  tail = tail.prev;

        //break the relation
        if(temp.prev!=null) temp.prev.next = temp.next;
        if(temp.next!=null) temp.next.prev = temp.prev;

        temp.prev = null;
        temp.next = null;

        addToHead(temp);
    }

    private void addToHead(Node temp) {
        if(head==null ) {
            head = tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            moveToHead(temp);
            return temp.value;
        }
        return -1;
    }
}
