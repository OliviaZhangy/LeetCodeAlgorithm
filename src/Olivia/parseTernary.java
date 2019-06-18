package src.Olivia;

//NO 439
//stack

import java.util.Stack;

public class parseTernary {
    public String parseTernary(String expression) {
        //corner case
        if(expression==null||expression.length()==0) return"";
        Stack<Character> stack = new Stack<>();
        for(int i=expression.length()-1;i>=0;i--){
            char cur = expression.charAt(i);
            if(!stack.isEmpty()&&stack.peek()=='?'){
                //pop ?
                stack.pop();
                char first = stack.pop();
                //pop :
                stack.pop();
                char second = stack.pop();
                if(cur=='T') stack.push(first);
                else stack.push(second);
            }
            else{
            stack.push(cur);}
        }
        return stack.pop().toString();
    }
}
