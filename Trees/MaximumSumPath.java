package Trees;

import java.util.Map;

public class MaximumSumPath {

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

    private int ans = Integer.MIN_VALUE;

    private int helper(TreeNode root) {
        if(root==null)  return 0;

        int l = Math.max(helper(root.left), 0);
        int r = Math.max(helper(root.right), 0);

        ans = Math.max(ans, root.val + l + r);
        return root.val + Math.max(l,r);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
}
