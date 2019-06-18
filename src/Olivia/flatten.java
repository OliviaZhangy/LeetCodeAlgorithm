package src.Olivia;


//NO 114
//stack

import java.util.Stack;

public class flatten {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        //get to the last element of flat left
        TreeNode cur = root;
        while(cur.right!=null){
            cur = cur.right;
        }
        cur.right = right;
    }
}
