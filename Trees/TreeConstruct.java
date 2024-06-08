package Trees;

public class TreeConstruct {


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


    int index = 0;
    public TreeNode preOrderHelper(int[] in, int[] pre, int l, int r) {
        if(index==in.length || l>r)    return null;
        int curr = pre[index++];
        int inOrderIndex = findInOrderIndex(curr, in, l, r);
        TreeNode root = new TreeNode(curr);
        root.left = preOrderHelper(in, pre, l, inOrderIndex-1);
        root.right = preOrderHelper(in, pre, inOrderIndex+1, r);
        return root;
    }

    private int findInOrderIndex(int curr, int[] in, int l, int r) {
        for(int i=l;i<=r;i++) {
            if(in[i]==curr) return i;
        }
        return -1;
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        return preOrderHelper(in, pre,  0, in.length-1);
    }
}
