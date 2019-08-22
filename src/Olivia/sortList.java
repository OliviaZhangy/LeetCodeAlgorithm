package src.Olivia;


//NO 148
//merge sort
public class sortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode sortList(ListNode head) {
        //corner case
        if(head==null||head.next==null) return head;
        //split the head to two parts
        ListNode low = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast!=null&&fast.next!=null){
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }
        pre.next = null;


        //sort the two list
        ListNode left = sortList(head);
        ListNode right = sortList(low);
        //merge together

        return merge(left,right);
    }
    private ListNode merge(ListNode s1, ListNode s2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        //corner case
        if(s1==null) return s2;
        if(s2==null) return s1;

        while (s1!=null&&s2!=null){
            if(s1.val<s2.val){
                cur.next = s1;
                s1 = s1.next;
            }
            else{
                cur.next = s2;
                s2 = s2.next;
            }
            cur = cur.next;
        }
        if(s1!=null) cur.next = s1;
        if(s2!=null) cur.next = s2;
        return dummy.next;
    }
}
