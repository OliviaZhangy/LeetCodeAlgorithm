package src.Olivia;

//NO 111
//tree

public class minDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int minDepth(TreeNode root) {
        //corner case
        if (root == null) return 0;
       if(root.left==null)
           return minDepth(root.right)+1;
       if(root.right==null)
           return minDepth(root.left)+1;
       return Math.min(minDepth(root.left),minDepth(root.right)) +1;
    }

}
