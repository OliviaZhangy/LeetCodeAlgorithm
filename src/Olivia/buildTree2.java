package src.Olivia;

//NO 106
//tree

public class buildTree2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)
            return null;
        return buildHelper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    private TreeNode buildHelper(int[] inorder, int[] postorder,int instart,int inend, int postart,int posend){
        if(postart>posend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[posend]);
        int tmp=0;
        for(int i = instart; i<= inend;i++){
            if(inorder[i]==root.val){
                tmp=i;
                break;
            }
        }
        TreeNode left  = buildHelper(inorder,postorder,instart,tmp-1,postart,postart-instart+tmp-1);
        TreeNode right = buildHelper(inorder,postorder,tmp+1,inend,posend-inend+tmp,posend-1);
        root.left=left;
        root.right=right;
        return root;
    }
}
