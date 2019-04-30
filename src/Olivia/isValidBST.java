package src.Olivia;

//NO 98
//tree

public class isValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return validHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean validHelper(TreeNode root, long left,long right){
        if(root==null)
            return true;
        if(root.val<=left||root.val>=right)
            return false;
        boolean result = validHelper(root.left,left,root.val)&&validHelper(root.right,root.val,right);
        return result;

    }
}
