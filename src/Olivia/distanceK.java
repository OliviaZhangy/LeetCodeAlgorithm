package src.Olivia;

import java.util.*;

//NO 863
//BFS and graph

public class distanceK {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root==null||K<0) return res;
        //construct a map to store the node as the key and parent and children as the value
        Map<TreeNode,List<TreeNode>> map = new HashMap<>();
        buildHelper(map,root,null);
        if(!map.containsKey(target)) return res;
        // a set that contains the tree node visited !!
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(target);
        visited.add(target);
        //do BFS
        while (!que.isEmpty()){
            int size = que.size();
            if(K==0){
                for(int i=0;i<size;i++){
                    res.add(que.poll().val);
                }
                return res;
            }
            for(int i=0;i<size;i++){
                TreeNode cur = que.poll();
                for(TreeNode tmp:map.get(cur)){
                    if(visited.contains(tmp)) continue;
                    visited.add(tmp);
                    que.add(tmp);
                }
            }
            K--;
        }
        return res;

    }
    private void buildHelper(Map<TreeNode,List<TreeNode>> map, TreeNode root, TreeNode parent){
        //base case
        if(root==null) return;
        if(!map.containsKey(root)){
            map.put(root,new ArrayList<>());

            if(parent!=null){
                //add the parent to the root
                map.get(root).add(parent);
                //add the root to the parent
                map.get(parent).add(root);
            }
            buildHelper(map,root.left,root);
            buildHelper(map,root.right,root);
        }
    }
}
