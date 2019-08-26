package src.Olivia;

public class removeZeroSumSublists {
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode removeZeroSumSublists(ListNode head) {
        //corner case
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
return null;
    }

}
