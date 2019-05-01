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
        return buildHelper(inorder,postorder,0,0,postorder.length-1);
    }
    private TreeNode buildHelper(int[] inorder, int[] postorder,int instart, int postart,int posend){
        if(instart>postorder.length-1||postart>posend){
            return null;
        }
        for(int i = postart;i<=posend;i++){
            
        }
    }
}
