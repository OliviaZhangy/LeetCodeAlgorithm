package src.Olivia;

//NO 82
//two pointers

import java.util.List;

public class deleteDuplicates {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //need two pointer one pre and one cur
    public ListNode deleteDuplicates(ListNode head) {
        //corner case
        if(head==null||head.next==null) return head;
        ListNode res = new ListNode(head.val==1?0:1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode result = res;

        while(cur!=null&&cur.next!=null){
            //if it is unique
            if(cur.val!=pre.val&&cur.val!=cur.next.val){
                result.next = cur;
                result = result.next;
            }
            pre = cur;
            cur = cur.next;
        }
        if(pre.val!=cur.val){
            result.next = cur;
            result = result.next;
        }
        result.next=null;
        return res.next;


    }
}
