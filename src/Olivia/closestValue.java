package src.Olivia;

//NO 270
//bst


public class closestValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

    public int closestValue(TreeNode root, double target) {
        int val = root.val;
        while(root!=null){
            if(Math.abs(target-root.val)<Math.abs(target-val)){
                val = root.val;
            }
            root = root.val>target? root.left:root.right;
        }
        return val;
    }
}
