package src.Olivia;

import java.util.LinkedList;
import java.util.Queue;

public class Codec2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //base case
        if(root==null) return "n,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        String left = serialize(root.left);
        String right = serialize(root.right);
        sb.append(left).append(right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for(String cur:str){
            list.add(cur);
        }
        return deHelper(list);
    }
    private TreeNode deHelper(LinkedList<String> list){
        String cur = list.poll();
        if(cur.equals("n")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deHelper(list);
        root.right = deHelper(list);
        return root;
    }
}
