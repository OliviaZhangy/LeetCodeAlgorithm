package src.Olivia;

//NO 333
//tree

public class largestBSTSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//return array for each node
// result[0] is min, result[1] is max, result[2] is the largest bst

    public int largestBSTSubtree(TreeNode root) {
        int[] result = treeHelper(root);
        return result[2];

    }
    private int[] treeHelper(TreeNode root){
        if(root==null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int[] left = treeHelper(root.left);
        int[] right = treeHelper(root.right);
        if(root.val>left[1]&&root.val<right[0]){
            return new int[]{Math.min(left[0],root.val),Math.max(right[1],root.val),left[2]+right[2]+1};
        }
        else{
            return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left[2],right[2])};
        }
    }
}
