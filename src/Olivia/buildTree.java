package src.Olivia;

//NO 105
//tree
//inorder: left,root,right preorder:root,left,right

public class buildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return buildHelper(preorder,inorder,0,0,preorder.length-1);

    }

    private TreeNode buildHelper(int[]preorder, int[] inorder,int prestart,int instart, int inend){
        if(instart>preorder.length-1||instart>inend)
            return null;
        TreeNode root  = new TreeNode(preorder[prestart]);
        int rootLoc=0;
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==preorder[prestart]){
                rootLoc = i;
                break;
            }
        }
        TreeNode left = buildHelper(preorder,inorder,prestart+1,instart,rootLoc-1);
        TreeNode right = buildHelper(preorder,inorder,prestart+rootLoc-instart+1,rootLoc+1,inend);
        root.left = left;
        root.right = right;
        return root;
    }
}

