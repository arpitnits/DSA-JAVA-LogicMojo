package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SpiralTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)  return new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>(); //left->right
        Stack<TreeNode> s2 = new Stack<>(); //right->left
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp;

        s2.add(root);
        TreeNode curr = null;

        while(!s2.isEmpty() || !s1.isEmpty()) {

            temp = new ArrayList<>();
            while(!s2.isEmpty()) {
                curr = s2.pop();
                temp.add(curr.val);

                if(curr.left!=null)  s1.add(curr.left);
                if(curr.right!=null)  s1.add(curr.right);
            }
            if(temp.size()>0) ls.add(temp);

            temp = new ArrayList<>();
            while(!s1.isEmpty()) {
                curr = s1.pop();
                temp.add(curr.val);

                if(curr.right!=null)  s2.add(curr.right);
                if(curr.left!=null)  s2.add(curr.left);
            }
            if(temp.size()>0) ls.add(temp);
        }
        return ls;
    }
}
