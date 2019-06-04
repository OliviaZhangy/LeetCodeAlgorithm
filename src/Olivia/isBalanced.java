package src.Olivia;

//NO 110
//tree

public class isBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return balanceHelper(root)!=-1;
    }
    private int balanceHelper (TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = balanceHelper(root.left);
        int rightHeight = balanceHelper(root.right);
        if(leftHeight==-1)
            return -1;
        if(rightHeight==-1)
            return -1;
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
