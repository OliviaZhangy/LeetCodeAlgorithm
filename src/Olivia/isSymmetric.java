package src.Olivia;

//NO 101
//tree

public class isSymmetric {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return symHelper(root.left,root.right);

    }
    private boolean symHelper(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return symHelper(left.left,right.right)&&symHelper(left.right,right.left);
    }
}
