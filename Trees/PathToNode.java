package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {

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

    private boolean hasPath(TreeNode curr, int key, List<Integer> path) {
        if(curr==null)  return false;
        if(curr.val == key) {
            return true;
        }

        path.add(curr.val);

        if(hasPath(curr.left, key, path) ||
                hasPath(curr.right, key, path))
            return true;

        path.remove(path.size()-1);
        return false;
    }

    public List<Integer> findPath(TreeNode root){
        List<Integer> path = new ArrayList<>();
        int key =3;
        hasPath(root, key, path);
        return path;
    }
}
