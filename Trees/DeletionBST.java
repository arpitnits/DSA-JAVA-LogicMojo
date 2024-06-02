package Trees;

public class DeletionBST {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }

        public Node deleteBST(Node curr, int key) {

            if(curr==null) return null;

            if(key < curr.data) {
                curr.left = deleteBST(curr.left, key);
            } else if(key > curr.data) {
                curr.right = deleteBST(curr.right, key);
            } else {
                //matched

                //caseI : leaf Node
                if(curr.left==null && curr.right==null) {
                    return null;
                } else if(curr.left==null) {
                    return curr.right;
                } else if(curr.right==null) {
                    return curr.left;
                } else {
                   //two child -> replace with inOrder successor
                    Node successor = curr.right;
                    Node successorParent = curr;
                    while (successor.left!=null) {
                        successorParent = successor;
                        successor = successor.left;
                    }

                    curr.data = successor.data;
                    if(successorParent==curr) successorParent.right=successor.right;
                    else successorParent.left = successor.right;
                }
            }
            return curr;
        }
    }



}
