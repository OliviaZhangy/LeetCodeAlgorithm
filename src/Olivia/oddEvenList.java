package src.Olivia;

//No 328

public class oddEvenList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode oddEvenList(ListNode head) {
        //corner case
        if(head==null||head.next==null||head.next.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return dummy.next;
    }
}
