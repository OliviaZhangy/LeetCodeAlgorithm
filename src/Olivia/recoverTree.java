package src.Olivia;

//No 99
//how to do it in O1 space
//use Morris Traversal

public class recoverTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {

        TreeNode first = null;     // first node need to be swap
        TreeNode second = null;    // second node need to be swap
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);  //previous node.

        while(root!=null){
            TreeNode node = root.left;

            // If left is not null, we need to find the rightmost node of left subtree,
            // Set its right child to current node
            if(node!=null){

                //find the rightmost
                while(node.right!=null && node.right != root){
                    node = node.right;
                }

                //There are two cases,
                //null: first time we access current, set node.right to current and move to left child of current and continue;
                //current: we accessed current before, thus we've finished traversing left subtree, set node.right back to null;
                if(node.right == null){
                    node.right = root;
                    root = root.left;
                    continue;
                }else{
                    node.right = null;
                }
            }

            // compare current node with previous node
            if(root.val < pre.val ){
                // first time we encounter reversed order, we set previous node to first
                if( first == null ){
                    first = pre;
                }
                //In case that two nodes are successive, we set second to current every time.
                second = root;
            }
            pre = root;
            root = root.right;
        }

        //swap the value;
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }

}
