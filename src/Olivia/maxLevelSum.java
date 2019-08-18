package src.Olivia;

//NO 1161

import java.util.LinkedList;
import java.util.Queue;

public class maxLevelSum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        int res = 1;
        int max = Integer.MIN_VALUE;
        while(!que.isEmpty()){
            int size = que.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode tmp = que.poll();
                if(tmp.left!=null) que.add(tmp.left);
                if(tmp.right!=null) que.add(tmp.right);
                sum += tmp.val;
            }
            if(sum>max){
                max = Math.max(max,sum);
                res = level;
            }
            level++;
        }
        return res;
    }
}
