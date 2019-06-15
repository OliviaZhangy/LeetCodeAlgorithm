package src.Olivia;

//NO 230
//find kth

public class kthSmallest {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
     count = k;
     findHelper(root);
     return result;
    }
    private void findHelper(TreeNode root){
        if(root.left!=null)
            findHelper(root.left);
        count--;
        if(count==0) {
            result = root.val;
            return;
        }
        if(root.right!=null)
            findHelper(root.right);

    }
}
