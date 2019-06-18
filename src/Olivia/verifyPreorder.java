package src.Olivia;

//NO 255
//stack

import java.util.Stack;

public class verifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int x:preorder){
            if(x<low)
                return false;
            while(!stack.isEmpty()&&x>stack.peek()){
                low = stack.pop();
            }
            stack.push(x);
        }
        return true;
    }
}
