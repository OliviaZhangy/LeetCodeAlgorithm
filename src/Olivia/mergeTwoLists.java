package src.Olivia;

//NO 21

public class mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //corner case
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        if(l1.val<l2.val){
            cur.next = l1;
            cur = l1;
            ListNode next = mergeTwoLists(l1.next,l2);
            cur.next = next;
        }
        else{
            cur.next = l2;
            cur = l2;
            ListNode next = mergeTwoLists(l1,l2.next);
            cur.next = next;
        }
        return dummy.next;
    }
}
