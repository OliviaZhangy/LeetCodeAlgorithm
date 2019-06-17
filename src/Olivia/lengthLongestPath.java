package src.Olivia;

//NO 388
//stack

import java.util.Stack;

public class lengthLongestPath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        //to avoid the empty stack
        stack.push(0);
        for(String cur : input.split("\n")){
            int lev = (cur.lastIndexOf("\t"))+1;
            while(lev+1<stack.size()){
                stack.pop();
            }
            //remove /t and and /
            int len = stack.peek() + cur.length() - (lev) + 1;
            stack.push(len);
            //if it is a file
            if(cur.contains(".")){
                max = Math.max(max,len-1);
            }
        }
        return max;
    }
}
