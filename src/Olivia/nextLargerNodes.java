package src.Olivia;

import java.util.Stack;

public class nextLargerNodes {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public int[] nextLargerNodes(ListNode head) {
        //corner case
        if(head==null) return null;
        int size = 0;
        ListNode cur = head;
        ListNode p = head;
        while(cur!=null){
            size++;
            cur = cur.next;
        }
        int[] res = new int[size];
        Stack<int[]> stack = new Stack<>();
        int count = 0;
        while(p!=null){
            int[] tmp = new int[2];
            tmp[0] = count;
            tmp[1] = p.val;
            while (!stack.isEmpty()&&stack.peek()[1]<tmp[1]){
                res[stack.peek()[0]] = tmp[1];
                stack.pop();
            }
            stack.add(tmp);
            p = p.next;
            count++;
        }
        return res;
    }
}
