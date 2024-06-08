package Trees;

public class LCA {

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

    public TreeNode LCABinaryTree(TreeNode root, TreeNode a, TreeNode b) {
        if(root==null)  return null;

        if(root==a || root==b)  return root;

        TreeNode leftLCA = LCABinaryTree(root.left, a,b);
        TreeNode rightLCA = LCABinaryTree(root.right, a,b);

        if(leftLCA!=null && rightLCA!=null) return root;

        if(leftLCA!=null) return leftLCA;
        else return rightLCA;
    }

    public TreeNode LCABinarySearchTree(TreeNode root, TreeNode a, TreeNode b) {
        if(root==null)  return null;

        //Ans will be if one of the node exist on left and other on right

        if(a.val < root.val && b.val <root.val)
            return LCABinarySearchTree(root.left, a, b);
        else if(a.val > root.val && b.val > root.val)
            return LCABinarySearchTree(root.right, a, b);
        else
            return root;
    }
}
