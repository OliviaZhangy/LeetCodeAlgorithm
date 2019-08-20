package src.Olivia;


//NO 145
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //recursive version, very easy
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        Helper(root,res);
//        return res;
//    }
//    private void Helper(TreeNode root, List<Integer> res){
//        if(root==null) return;
//        Helper(root.left,res);
//        Helper(root.right,res);
//        res.add(root.val);
//    }

    //iteration version
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp!=null){
                res.add(0,tmp.val);
                stack.push(tmp.left);
                stack.push(tmp.right);
            }
        }
        return res;
    }
}
