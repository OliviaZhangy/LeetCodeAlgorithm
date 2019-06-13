package src.Olivia;

//NO 141
//two pointers in linked list

import java.util.List;

public class hasCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //need two pointers, one go step by step, the other one go do step, if it can be equal, then has cycle
    public boolean hasCycle(ListNode head) {
        //corner case
        if(head==null||head.next==null)
            return false;
        ListNode low = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            low = low.next;
            fast = fast.next.next;
            if(low==fast) return true;
        }
        return false;

    }
}
