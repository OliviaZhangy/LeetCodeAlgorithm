package src.Olivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//NO 199
//BFS

public class rightSideView {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
    //corner case
        if(root==null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()){
            int size = que.size();
            while (size>0){
                TreeNode cur = que.poll();
                if(size==1){
                    res.add(cur.val);
                }
                if(cur.left!=null){
                    que.add(cur.left);
                }
                if(cur.right!=null){
                    que.add(cur.right);
                }
                size--;
            }
        }
        return res;
    }

}
