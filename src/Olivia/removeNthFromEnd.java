package src.Olivia;

//NO 19
//two pointers

public class removeNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        ListNode pre = head;
        ListNode post = head;
        while(n>0){
            post = post.next;
            n--;
        }
        if(post==null){
            return head.next;
        }
        while(post.next!=null){
            post = post.next;
            pre = pre.next;
        }
        ListNode tmp = pre.next.next;
        pre.next = tmp;
        return head;
    }
}
