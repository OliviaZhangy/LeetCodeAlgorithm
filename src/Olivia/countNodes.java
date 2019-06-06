package src.Olivia;


//NO 222
public class countNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        int result = 0;
        return countHelper(root,result);

    }
    private int countHelper(TreeNode root,int result){
        //corner case
        if(root==null){
            return result;
        }
        if(root.left==null&&root.right==null){
            result++;
            return result;
        }
        return countHelper(root.left,result) + countHelper(root.right,result)+1;
    }
}
