package src.Olivia;

//NO 83
//two pointers

public class deleteDuplicates2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(head.val==1?0:1);
        dummy.next = head;
        ListNode cur = head;
        ListNode result = dummy;
        while(cur!=null&&cur.next!=null){
            if(cur.val!=result.val){
                result.next = cur;
                result = result.next;
            }
            cur = cur.next;
        }

        //look at the last value
        if(cur.val!=result.val){
            result.next = cur;
            result = result.next;
        }
        result.next = null;
        return dummy.next;
    }
}
