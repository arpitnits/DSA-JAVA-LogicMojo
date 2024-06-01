package Trees;

public class InsertionBST {

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


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);

        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode searchIntoBST(TreeNode root, int val) {
        if(root==null) return null;

        if(val == root.val) {
            return root;
        } else if(val < root.val) {
            searchIntoBST(root.left, val);
        } else {
            searchIntoBST(root.right, val);
        }
        return root;
    }
}
