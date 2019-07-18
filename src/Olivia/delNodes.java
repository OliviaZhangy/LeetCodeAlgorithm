package src.Olivia;
//NO 1110

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class delNodes {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        //corner case
        if(root==null) return res;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        Helper(root,true,res,set);
        return res;
    }
    //return true if it is not deleted, otherwise deleted
    private boolean Helper(TreeNode root, boolean isRoot, List<TreeNode> list, Set<Integer> set){
        //corner case
        if(root==null) return false;
        boolean isDelete = set.contains(root.val);
        if(isRoot&&!isDelete) list.add(root);
        boolean left = Helper(root.left,isDelete,list,set);
        boolean right = Helper(root.right,isDelete,list,set);
        if(left) root.left=null;
        if (right) root.right =null;
        return isDelete;
    }

}
