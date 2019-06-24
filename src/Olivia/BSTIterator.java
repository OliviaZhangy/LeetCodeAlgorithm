package src.Olivia;

//NO 173
//iterator

/**
 * Definition for a binary tree node.
 public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Stack;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if(root==null) return;
        TreeNode cur = root;
        stack.push(cur);
        while(cur.left!=null){
            stack.push(cur.left);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = stack.pop();
        int result = pop.val;
        if(pop.right!=null){
            stack.push(pop.right);
            pop = pop.right;
            while (pop.left!=null){
                stack.push(pop.left);
                pop = pop.left;
            }
        }
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        else return true;
    }

}
