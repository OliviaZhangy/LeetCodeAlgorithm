import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
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
};
*/
public class connect{
    public Node connect(Node root) {
        Node result = root;
        //corner case
        if(root==null)
            return root;
        //initial a queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int level_len= queue.size();
            Node poi = queue.peek();
            for(int i=0;i<level_len;i++){
                Node cur = queue.remove();
                if(i==level_len-1){
                    poi.next=null;
                }
                else {
                    poi.next = queue.peek();
                    poi = poi.next;
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }

            level++;

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
