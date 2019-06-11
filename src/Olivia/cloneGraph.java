package src.Olivia;

//NO 133
//graph


import java.util.*;

public class cloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer,Node> map = new HashMap<>();
        return cloneHelper(node,map);
    }
    private Node cloneHelper(Node node, Map<Integer,Node> map){
        //corner case
        if(node==null) return null;
        if(map.containsKey(node.val)) {
            return map.get(node.val);}
        else{
            Node newNode = new Node(node.val,new ArrayList<Node>());
            map.put(node.val,newNode);
            for(int i=0;i<node.neighbors.size();i++){
                newNode.neighbors.add(cloneHelper(node.neighbors.get(i),map));
            }
            return newNode;
        }

    }
}
