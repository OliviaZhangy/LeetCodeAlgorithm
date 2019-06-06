package src.Olivia;

//NO 2

public class addTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1,l2,0);
    }
    private ListNode addHelper(ListNode l1,ListNode l2, int count){
        if(l1==null&&l2==null&&count==0)
            return null;
        int sum = count;
        if(l1!=null){
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2!=null){
            sum += l2.val;
            l2 = l2.next;
        }
        if(sum>9){
            sum = sum%10;
            count = 1;
        }
        else{
            count = 0;
        }
        ListNode result = new ListNode(sum);
        result.next = addHelper(l1,l2,count);
        return result;
    }
}
