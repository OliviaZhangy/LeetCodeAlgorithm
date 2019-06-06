package src.Olivia;

//NO 113
//tree

import com.sun.javafx.tk.quantum.PathIteratorHelper;

import java.util.ArrayList;
import java.util.List;

public class pathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        pathHelper(result,cur,sum,root);
        return result;
    }
    private void pathHelper(List<List<Integer>> result,List<Integer> cur, int sum, TreeNode root){
        if(root==null) return;
        cur.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            result.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size()-1);
            return;
        }

        pathHelper(result,cur,sum-root.val,root.left);
        pathHelper(result,cur,sum-root.val,root.right);
        cur.remove(cur.size()-1);
    }


}
