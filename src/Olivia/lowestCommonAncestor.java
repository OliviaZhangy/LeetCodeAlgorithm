package src.Olivia;

//NO 235
//tree

//Just walk down from the whole tree's root
// as long as both p and q are in the same subtree
// (meaning their values are both smaller or both larger than root's)

public class lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      while((root.val-p.val)*(root.val-q.val)>0){
          root = root.val>p.val? root.left:root.right;
      }
      return root;
    }
}
