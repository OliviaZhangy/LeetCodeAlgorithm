package src.Olivia;

//No 968

public class minCameraCover {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //return 0 if it is a leaf
    //return 1 if it is in a camera
    //return 2 if it is a parent node which is covered
    int res = 0;
    public int minCameraCover(TreeNode root) {
        //corner case
        if(root==null) return 0;
        //need to check whether to place a camera at the root
        return (dfs(root)<1?1:0)+res;
    }
    private int dfs(TreeNode root){
        if(root==null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //need gto place a camera
        if(left==0||right==0) {
            res++;
            return 1;
        }
        //if it is covered return 2
        if(left==1||right==1) return 2;
        else
            return 0;
    }
}
