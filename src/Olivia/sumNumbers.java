package src.Olivia;

//NO 129
//tree

public class sumNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        int result = 0;
        return sumHelper(root,result);
    }
    private int sumHelper(TreeNode root, int result){
        //corner case
        if(root==null){
           return 0;
        }
        if(root.left==null&&root.right==null){
            result = result*10 + root.val;
            return result;
        }

        return sumHelper(root.left,result*10+root.val) + sumHelper(root.right,result*10+root.val);
    }
}

