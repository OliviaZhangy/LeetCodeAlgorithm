package src.Olivia;

//NO 307
//balanced bst

public class NumArray {
    class SegmentTreeNode{
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left=null;
            this.right=null;

        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
         root = buildTree( nums, 0,nums.length-1);
    }
    private SegmentTreeNode buildTree(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        else {
            SegmentTreeNode result = new SegmentTreeNode(start, end);
            if (start == end) {
                result.sum = nums[start];
            } else {
                int mid = start+(end-start)/2;
                SegmentTreeNode left = buildTree(nums,start,mid);
                SegmentTreeNode right = buildTree(nums,mid+1,end);
                result.left = left;
                result.right = right;
                result.sum = left.sum + right.sum;
            }
            return result;
        }
    }

    public void update(int i, int val) {
        updateHelper(root,i,val);
    }
    private void updateHelper(SegmentTreeNode root,int i,int val){
        if(root.start==root.end){
            root.sum = val;
        }
        else{
            int mid = root.start+(root.end-root.start)/2;
            if(i<=mid){
                updateHelper(root.left,i,val);
            }
            else{
                updateHelper(root.right,i,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }

    }

    public int sumRange(int i, int j) {
        return sumHelper(i,j,root);
    }
    private int sumHelper(int i, int j,SegmentTreeNode root){
        if(root.start==i&&root.end==j)
            return root.sum;
        else{
            int mid = root.start+(root.end-root.start)/2;
            if(j<=mid){
                return sumHelper(i,j,root.left);
            }
            else if (i>=mid+1){
                return sumHelper(i,j,root.right);
            }
            else {
                return sumHelper(i,mid,root.left) + sumHelper(mid+1,j,root.right);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
