package src.Olivia;

//NO 95
//tree
//use divide and conquer

import java.util.ArrayList;
import java.util.List;

public class generateTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n==0) return list;
        return generateHelper(1,n);

    }
    private List<TreeNode> generateHelper(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++) {
            List<TreeNode> leftside = generateHelper(start, i - 1);
            List<TreeNode> rightside = generateHelper(i + 1, end);
            for (TreeNode left : leftside) {
                for(TreeNode right: rightside){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
