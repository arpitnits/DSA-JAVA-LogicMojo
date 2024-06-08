package Trees;

public class FlattenATree {

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

    public void flatten(TreeNode root) {

        while(root!=null) {
            if(root.left!=null) {
                TreeNode curr = root;
                TreeNode temp = curr.right;
                curr.right = curr.left;
                curr.left = null;

                while(curr.right!=null) {
                    curr = curr.right;
                }
                curr.right = temp;
            }
            root = root.right;
        }
    }
}
