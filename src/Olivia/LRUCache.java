package src.Olivia;

//NO 146 LRU cache


import java.awt.*;
import java.util.Hashtable;

//The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
// One interesting property about double linked list is that the node can remove itself without other reference.
// In addition, it takes constant time to add and remove nodes from the head or tail.

class LRUCache {

    class DLinkedNode{
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
    }
    //add new node, new node connects to head
    private void addNode(DLinkedNode node){
            node.pre = head;
            node.post = head.post;
            head.post.pre = node;
            head.post = node;

    }
    //remove existing node from the linked list
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    //move certain node in between to head
    private void moveToHead(DLinkedNode node){
       this.removeNode(node);
       this.addNode(node);
    }

    //pop the current tail
    private DLinkedNode popTail(){
        DLinkedNode pop = tail.pre;
        this.removeNode(pop);
        return pop;
    }

    private Hashtable<Integer,DLinkedNode> cache = new Hashtable<>();

    private DLinkedNode head,tail;

    private int capacity;
    private int count;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null) {return -1;}
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key,newNode);
            this.addNode(newNode);
            count++;
            if(count>capacity){
                DLinkedNode tail = this.popTail();
                cache.remove(tail.key);
                count--;
            }
        }
        //update the value
        else{
            node.value = value;
            this.moveToHead(node);
        }


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */