package src.Olivia;

//NO 298
//tree

public class longestConsecutive {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max;
    public int longestConsecutive(TreeNode root) {
        max = 1;
        //corner case
        if(root==null) return 0;
        lengthHelper(root,root.val,1);
        return max;
    }
    private void lengthHelper(TreeNode root,int preivious,int count){
        if(root==null) {
            max = Math.max(count,max);
            return;
        }
        //if it is consecutive
        if(root.val==preivious+1){
            count++;
        }
        //else compare it with max
        else{
            max = Math.max(count,max);
            count = 1;
        }
        lengthHelper(root.left,root.val,count);
        lengthHelper(root.right,root.val,count);
    }
}
