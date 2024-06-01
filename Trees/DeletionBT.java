package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeletionBT {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public Node deletionBT(Node root, int key){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        Node matched = null;
        Node curr = null;

        while (!q.isEmpty()) {
            curr = q.poll();
            if(curr.data==key) {
                matched = curr;
            }
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }

        if(matched==null)   return root;

        matched.data = curr.data;

        //deletion  bottom key
        return deleteBottomKey(root, curr);
    }


    public Node deleteBottomKey(Node root, Node bottomNode) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if(curr==bottomNode) {
                curr = null;
                return root;
            }

            if(curr.left!=null) {
                if(curr.left==bottomNode) {
                    curr.left =null;
                    return root;
                }
                q.add(curr.left);
            }

            if(curr.right!=null) {
                if(curr.right==bottomNode) {
                    curr.right =null;
                    return root;
                }
                q.add(curr.right);
            }
        }
        return root;
    }
}
