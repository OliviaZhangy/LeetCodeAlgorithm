package src.Olivia;

import java.util.LinkedList;
import java.util.Queue;

public class connect2 {
    public Node connect(Node root) {
        Node result = root;
        if(root==null||root.right==null){
            return result;
        }
        //initial a queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node pointer = queue.peek();
            int len = queue.size();
            for(int i=0;i<len;i++){
                Node cur = queue.remove();
                if(i!=len-1){
                    pointer.next = queue.peek();
                    pointer = pointer.next;
                }
                else{
                    pointer = null;
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }
        return result;

    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
