package src.Olivia;

//NO 94
//tree

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root,result);
        return result;

    }
    private void inorderHelper(TreeNode root, List<Integer> result){
        if(root!=null){
            inorderHelper(root.left,result);
            result.add(root.val);
            inorderHelper(root.right,result);
        }

    }
}
