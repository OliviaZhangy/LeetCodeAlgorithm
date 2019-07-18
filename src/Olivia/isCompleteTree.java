package src.Olivia;

//NO 958


import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isCompleteTree(TreeNode root) {
        //corner case
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root);
        while(queue.peek()!=null){
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        //when meet the null, it should be null to the end
        while(!queue.isEmpty()&&queue.peek()==null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}
