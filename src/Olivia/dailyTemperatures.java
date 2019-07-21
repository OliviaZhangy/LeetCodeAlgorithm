package src.Olivia;
//NO 739

import java.util.Stack;

//use stack to avoid O(n^2)
public class dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int idex = stack.pop();
                result[idex] = i-idex;
            }
            stack.push(i);
        }
        return result;
    }
}
