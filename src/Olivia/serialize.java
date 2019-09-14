package src.Olivia;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.

//NO 297
public class serialize {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        int val = root.val;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> que = new LinkedList<String>(Arrays.asList(strs));
        return decode(que);
    }
    private TreeNode decode(Queue<String> que){
        if(que.isEmpty()) return null;
        String cur = que.poll();
        if(cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        TreeNode left = decode(que);
        TreeNode right = decode(que);
        root.left = left;
        root.right = right;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));