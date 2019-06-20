package src.Olivia;

//NO 92
// list rotation

public class reverseBetween {


    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    }


     public ListNode reverseBetween(ListNode head, int m, int n) {
         //corner case
         if (head == null || head.next == null)
             return head;
         if (m == n)
             return head;


         ListNode tmp = head;
         ListNode pointer =null;
         ListNode reverseHead = head;
         ListNode reverseTail = head;
         int count = 1;
         ListNode cur = head;
         while(cur!=null){
             //give pointer node
             if((count==m||count==m-1)&&pointer==null)
                 pointer = cur;
             //need to reverse the list
             if(count ==m){
                 reverseHead = new ListNode(cur.val);
                 reverseTail = reverseHead;
             }

             else if(count>m&&count<=n){
                tmp = new ListNode(cur.val);
                tmp.next = reverseHead;
                reverseHead = tmp;
             }
             //when it comes to the end
             if(count==n){
                 pointer.next = reverseHead;
                 reverseTail.next = cur.next;
                 //corner case
                 if(m==1)
                     return reverseHead;
                 break;
             }
             cur = cur.next;
             count++;

         }
         return head;


     }
}
