//
//import java.util.*;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//public class levelOrderBottom{
//    public List<List<Integer>> levelOrderBottom1(TreeNode root){
//    List<List<Integer>> result = new ArrayList<List<Integer>>();
//    //special case when root is empty
//        if(root==null){
//        return result;
//    }
//    //give a queue
//    Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//    int level =0;
//        while(!queue.isEmpty()){
//        //initial the arraylist
//        result.add(new ArrayList<Integer>());
//
//        int level_length = queue.size();
//        for (int i=0; i<level_length;i++){
//            TreeNode cur = queue.remove();
//            result.get(level).add(cur.val);
//
//            //check the left child
//            if(cur.left!=null){
//                queue.add(cur.left);
//            }
//
//            //check the right child
//            if(cur.right!=null){
//                queue.add(cur.right);
//            }
//        }
//        level++;
//
//    }
//    Collections.reverse(result);
//
//        return result;
//}
//
//
//}
//public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }