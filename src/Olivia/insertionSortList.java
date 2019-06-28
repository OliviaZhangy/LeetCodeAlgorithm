package src.Olivia;

//NO 147
//others

public class insertionSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        //corner case
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur!=null){
            //if it is larger than the previous one
            if(cur.val >= pre.val){
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
            //need to insert to the right place
            else{
                ListNode next = dummy.next;
                ListNode tmp = dummy;
                while(next.val<cur.val){
                    next = next.next;
                    tmp = tmp.next;
                }
                //insert it
                pre.next = cur.next;
                tmp.next = cur;
                cur.next = next;
                cur = pre.next;
            }

        }
        return dummy.next;
    }
}
