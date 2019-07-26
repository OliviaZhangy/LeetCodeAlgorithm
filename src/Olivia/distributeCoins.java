package src.Olivia;

//NO 979

public class distributeCoins {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  int res=0;
    public int distributeCoins(TreeNode root) {
        Helper(root);
        return res;
    }
    private int Helper(TreeNode root){
        //base case
        if(root==null) return 0;
        //how many steps need to add or delete
        int left = Helper(root.left);
        int right = Helper(root.right);
        res += Math.abs(left)+Math.abs(right);
        return left+right+root.val-1;
    }
}
