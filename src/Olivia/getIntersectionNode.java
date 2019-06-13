package src.Olivia;

//NO 160
//two pointers

public class getIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    //great idea
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=p2){
            p1 = p1==null?headB:p1.next;
            p2 = p2==null?headA:p2.next;
        }
        return p1;
    }

}
