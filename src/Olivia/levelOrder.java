//package Olivia;
//
//public class levelOrder {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     * int val;
//     * TreeNode left;
//     * TreeNode right;
//     * TreeNode(int x) { val = x; }
//     * }
//     */
////
////    //initial the arraylist
////    List<List<Integer>> result = new ArrayList<List<Integer>>;
////
////    //using recursion
////    public void leverlHelper(int level, TreeNode node) {
////        if(level==result.size()){
////            result.add (new ArrayList<Integer>)
////        }
////
////        result.get(level).add(node.val);
////        //look at its left child
////        if(node.left!=null){
////            leverlHelper(level+1,node.left);
////
////        }
////        //look at its right child
////        if(node.right!=null){
////            leverlHelper(level+1,node.right);
////        }
////
////    }
////    public List<List<Integer>> levelOrder(TreeNode root) {
////        if(root==null) return result;
////        leverlHelper(0,root);
////        return result;
////    }
//
//
//    //Using iteration
//    public List<List<Integer>> levelOrder(TreeNode root){
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        //special case when root is empty
//        if(root==null){
//            return result;
//        }
//        //give a queue
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        int level =0;
//        while(!queue.isEmpty()){
//            //initial the arraylist
//            result.add(new ArrayList<Integer>());
//
//            int level_length = queue.size();
//            for (int i=0; i<level_length;i++){
//                TreeNode cur = queue.remove();
//                result.get(level).add(cur.val);
//
//                //check the left child
//                if(cur.left!=null){
//                    queue.add(cur.left);
//                }
//
//                //check the right child
//                if(cur.right!=null){
//                    queue.add(cur.right);
//                }
//            }
//            level++;
//
//        }
//        return result;
//    }
//}
