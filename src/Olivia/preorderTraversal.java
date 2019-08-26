package src.Olivia;

//NO 144
//stack

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //recursive version
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list= new ArrayList<>();
//        preHelper(root,list);
//        return list;
//    }
//    private  void preHelper(TreeNode root, List<Integer>list){
//        if(root==null)
//            return;
//        list.add(root.val);
//        if(root.left!=null) preHelper(root.left,list);
//        if(root.right!=null) preHelper(root.right,list);
//    }

    //iteration version :stack 1.first push right 2.then push left
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //corner case
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if (cur.left!=null) stack.push(cur.left);
        }
        return res;
    }

}
