package src.Olivia;

//NO 20
//stack

import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {
        if(s==null||s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for(char x : charArray){
            if(x=='(') stack.push(')');
            else if (x=='{') stack.push('}');
            else if(x=='[') stack.push(']');
            else if(stack.isEmpty()) return false;
            else if(stack.pop()!=x) return false;
        }
        //make sure at last is empty
        return stack.isEmpty();
    }
}
