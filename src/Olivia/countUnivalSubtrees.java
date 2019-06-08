package src.Olivia;

//NO 

public class countUnivalSubtrees {
    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        countHelper(root,0);
        return count;
    }

    private boolean countHelper(TreeNode root, int val){
        if(root==null)
            return true;
        boolean left = countHelper(root.left,root.val);
        boolean right = countHelper(root.right,root.val);
        if(left&&right){
            count++;
            return root.val==val;
        }
        return false;
    }
}
