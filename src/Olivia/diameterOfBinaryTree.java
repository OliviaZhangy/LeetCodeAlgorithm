package src.Olivia;

//NO 543

public class diameterOfBinaryTree {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root==null) return 0;
//        if(root.left==null&&root.right==null) return 0;
//        int left = diameterOfBinaryTree(root.left);
//        int right = diameterOfBinaryTree(root.right);
//        int max = maxDepth(root.left)+maxDepth(root.right);
//        return Math.max(max,Math.max(left,right));
//    }
//    private int maxDepth(TreeNode root){
//        if(root==null) return 0;
//        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
//    }

    //a better solution
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        path(root);
        return max;
    }

    private int path(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = path(root.left);
        int right = path(root.right);
        max = Math.max(max,left+ right);
        return Math.max(left, right)+1;
    }
}
