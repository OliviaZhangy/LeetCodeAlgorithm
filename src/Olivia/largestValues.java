package src.Olivia;

//NO515 Try using BFS

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestValues {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Integer> largestValues(TreeNode root) {
        //corner case

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        int max;
        queue.add(root);
        while(!queue.isEmpty()){
            max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.remove();
                max = Math.max(max,cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
