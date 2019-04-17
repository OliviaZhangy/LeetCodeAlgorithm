package src.Olivia;

//NO 257 Try use DFS

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if(root==null) return result;
        pathHelper(root,result,"");
        return result;
    }
    private void pathHelper(TreeNode root,List<String> result, String cur){
        int curr = root.val;
        String tmp = String.valueOf(curr);
        if(root.left==null&&root.right==null){
            cur = cur + "->"+tmp;
            result.add(cur);
            return;
        }
        if(root.left!=null){
            pathHelper(root.left,result,cur.isEmpty()?tmp:cur+"->"+tmp);
        }


        if(root.right!=null){
            pathHelper(root.right,result,cur.isEmpty()?tmp:cur+"->"+tmp);
        }
    }
}
