package Trees;

public class IdenticalTrees {

    //TC = O(MIN(m,n))
    public boolean isSameTree(InsertionBST.TreeNode p, InsertionBST.TreeNode q) {
        if(p==null && q==null)  return true;

        if(p!=null && q!=null)
            return p.val==q.val && isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);

        return false;
    }
}
