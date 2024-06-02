package Trees;

import java.util.*;

public class VerticalTraversal {

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


    TreeMap<Integer, List<Integer>> map;
    private void preOrder(TreeNode root, int level) {
        if(root==null)  return;

        map.getOrDefault(level, new ArrayList<>()).add(root.val);

        preOrder(root.left, level-1);
        preOrder(root.right, level+1);
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        preOrder(root,0);

        for(int key = map.firstKey(); key<=map.lastKey(); key++) {
            ans.add(map.get(key));
        }

        return ans;
    }
}
