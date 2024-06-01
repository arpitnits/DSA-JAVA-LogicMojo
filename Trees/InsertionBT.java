package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class InsertionBT {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public Node insertionBT(Node root, int key){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.left==null) {
                curr.left = new Node(key);
                break;
            } else {
                q.add(curr.left);
            }

            if(curr.right==null) {
                curr.right = new Node(key);
                break;
            } else {
                q.add(curr.right);
            }
        }
        return root;
    }
}
