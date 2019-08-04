//package Olivia;
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
//public class zigzagLevelOrder {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        //initial list
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        //when root ==null
//        if(root==null){
//            return result;
//        }
//        //initial a queue
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        int level=0;
//        int counter = 1;
//        while(!queue.isEmpty()){
//            result.add(new ArrayList<Integer>());
//            int len = queue.size();
//            for (int i=0; i<len;i++){
//                TreeNode curNode = queue.remove();
//                if(counter%2==1){
//                    result.get(level).add(curNode.val);
//                }
//                else{
//                    //每次加在list的左侧
//                    result.get(level).add(0,curNode.val);
//                }
//                if(curNode.left!=null){
//                    queue.add(curNode.left);
//                }
//                if(curNode.right!=null){
//                    queue.add(curNode.right);
//                }
//            }
//            level++;
//            counter++;
//        }
//        return result;
//
//    }
//    }
//
