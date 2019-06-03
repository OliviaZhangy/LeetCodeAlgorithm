package src.Olivia;

//NO 108
//tree

public class sortedArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        //c.c.
        if(nums.length==0) return null;
        return sortBuilder(nums,0,nums.length-1);

    }
    private TreeNode sortBuilder(int[] nums, int startLoc, int endLoc){
        if(startLoc>endLoc){
            return null;}
        int mid = endLoc-(endLoc-startLoc)/2 ;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortBuilder(nums,startLoc,mid-1);
        TreeNode right= sortBuilder(nums,mid+1,endLoc);
        root.left = left;
        root.right = right;
        return root;
}
}
