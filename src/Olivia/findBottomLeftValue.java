package src.Olivia;
//NO513
//Try using BFS


import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        int first = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
                while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.remove();
                if(i==0){
                    first = cur.val;
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }
        return first;
    }
}
