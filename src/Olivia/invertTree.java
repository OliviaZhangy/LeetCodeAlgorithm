package src.Olivia;


//NO 226
//tree

public class invertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        //do the inverse
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

}
