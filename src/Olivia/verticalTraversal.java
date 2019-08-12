package src.Olivia;

//NO 987

import Olivia.Insert57;
import Olivia.SwapPairs24;

import java.util.*;

//NO 987

public class verticalTraversal {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //focus on the structure, key is the x distance, value is sored by the y distance
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        dfs(root,0,0,map);
        for(TreeMap<Integer,PriorityQueue<Integer>> cur:map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> tmp:cur.values()){
                while (!tmp.isEmpty()){
                    res.get(res.size()-1).add(tmp.poll());
                }
            }
        }
        return res;
    }
    private void dfs(TreeNode root, int x,int y, TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map) {
       if(!map.containsKey(x)){
           map.put(x,new TreeMap<>());
       }
       if(!map.get(x).containsKey(y)){
           map.get(x).put(y,new PriorityQueue<>());
       }
       map.get(x).get(y).add(root.val);
       if(root.left!=null) dfs(root.left,x-1,y+1,map);
       if(root.right!=null) dfs(root.right,x+1,y+1,map);
    }
}
