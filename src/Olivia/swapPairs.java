package src.Olivia;

//NO 24
//list rotation

public class swapPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur = head.next;
        head.next = swapPairs(head.next.next);
        cur.next = head;
        return cur;
    }
}
