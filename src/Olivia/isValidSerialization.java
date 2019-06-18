package src.Olivia;

//NO 331
//stack

import java.util.Stack;

public class isValidSerialization {
    // using a stack, scan left to right
    // case 1: we see a number, just push it to the stack
    // case 2: we see #, check if the top of stack is also #
    // if so, pop #, pop the number in a while loop, until top of stack is not #
    // if not, push it to stack
    // in the end, check if stack size is 1, and stack top is #
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        for(String x:preorder.split(",")){
            if(!x.equals("#")){
                stack.push(x);
            }
            else{
                while (!stack.isEmpty()&&stack.peek().equals("#")){
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    stack.pop();
                    //pop the whole root means pop the left subtree of a root
                    //add # to check the right sub tree
                }
                stack.push("#");
            }
        }
        return stack.size()==1&&stack.peek().equals("#");
    }
}
