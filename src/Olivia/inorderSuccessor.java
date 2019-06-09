package src.Olivia;

//NO 285
//bst

public class inorderSuccessor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null) return null;
        if(root.val<=p.val){
            return inorderSuccessor(root.right,p);
        }
        else{
            TreeNode left = inorderSuccessor(root.left,p);
            return (left!=null)?left:root;
        }
    }
}
