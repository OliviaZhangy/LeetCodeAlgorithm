package src.Olivia;
//NO 1120

public class maximumAverageSubtree {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    double max = 0;
    public double maximumAverageSubtree(TreeNode root) {
        //corner case
        if(root==null) return 0;
        Helper(root);
        return max;
    }
    //return average,count
    private double[] Helper(TreeNode root){
        if(root==null){
            return new double[]{0,0};
        }
        //base case for null is ok
//        if(root.left==null&&root.right==null){
//            max = Math.max(max,root.val);
//            return new double[]{root.val,1};
//        }
        double[] left = Helper(root.left);
        double[] right = Helper(root.right);
        double average = (left[0]*left[1]+right[0]*right[1]+(double)root.val)/(left[1]+right[1]+1);
        max = Math.max(max,average);
        return new double[]{average,left[1]+right[1]+1};
    }
}
