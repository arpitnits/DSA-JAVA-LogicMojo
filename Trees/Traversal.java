package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Traversal {

     static class Node{
         int data;
         Node left,right;
         Node(int d){
             data=d;
             left=right=null;
         }
     }


    private void preOrder(Node root) {
        if(root==null)  return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        if(root==null)  return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    private void postOrder(Node root) {
        if(root==null)  return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    private void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            System.out.print(curr.data + " ");

            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
    }

    public List<List<Integer>> enhancedLevelOrder(Node root) {

        Queue<Node> q = new ArrayDeque<>();
        if(root==null)   return new ArrayList<>();

        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size>0) {
                Node curr = q.poll();
                temp.add(curr.data);

                if(curr.left!=null)   q.add(curr.left);
                if(curr.right!=null)    q.add(curr.right);
                size--;
            }
            ans.add(temp);
        }
        return ans;
    }
}
