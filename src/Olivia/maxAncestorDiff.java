package src.Olivia;

//NO 1026


public class maxAncestorDiff {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxAncestorDiff(TreeNode root) {
        //corner case
        if(root==null) return 0;
        return Helper(root,root.val,root.val);

    }
    private int Helper(TreeNode root, int max, int min){
        //corner case
        if(root==null) return max-min;
        max = Math.max(root.val,max);
        min = Math.min(root.val,min);
        int left = Helper(root.left,max,min);
        int right = Helper(root.right,max,min);
        return Math.max((max-min),Math.max(left,right));
    }
}
