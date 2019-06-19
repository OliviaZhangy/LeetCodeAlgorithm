package src.Olivia;

//NO 654
//stack

import java.util.Stack;

public class constructMaximumBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //corner case
        if(nums==null||nums.length==0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            TreeNode cur = new TreeNode(nums[i]);
            //if cur > stack peek, cur.left = stack peek
            while(!stack.isEmpty()&&nums[i]>stack.peek().val){
                cur.left = stack.pop();
            }
            //if cur < stack peek, peek.right = cur
            if(!stack.isEmpty()){
                stack.peek().right = cur;
            }
            stack.push(cur);

        }
        return stack.isEmpty()?null:stack.get(0);
    }
}
