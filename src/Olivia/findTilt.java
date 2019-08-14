package src.Olivia;

//NO 563
//dfs

public class findTilt {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int res=0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }
    //retrun the sum of all left subtree and right subtree and root value
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left-right);
        return left+right+root.val;
    }
}
