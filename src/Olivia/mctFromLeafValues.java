package src.Olivia;

import java.util.Stack;

//NO 1130
public class mctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int cur:arr){
            while (stack.peek()<=cur){
                int mid = stack.pop();
                res += mid*Math.min(stack.peek(),cur);
            }
            stack.push(cur);
        }
        while (stack.size()>2){
            res += stack.pop()*stack.peek();
        }
        return res;
    }
}
