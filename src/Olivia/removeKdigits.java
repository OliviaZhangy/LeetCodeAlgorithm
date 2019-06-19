package src.Olivia;

//NO 402
//stack

import java.util.Stack;

public class removeKdigits {
    //use a stack to store the digit
    //if it is smaller than than the previous one, discard the previous one
    public String removeKdigits(String num, int k) {
        //corner case
        if(num.length()==k){
            return "0";
        }
        int count = k;
        Stack<Character> stack = new Stack<>();
        //pop numbers
        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty()&&stack.peek()>num.charAt(i)&&count>0){
                stack.pop();
                count--;
            }
            stack.push(num.charAt(i));
        }
        //if exist same numbers
       while(count>0){
            stack.pop();
            count--;
        }
        //get the whole string and -leading "0"
        StringBuilder sb = new StringBuilder();
       while (!stack.isEmpty()){
           sb.insert(0,stack.pop());
       }
//        while(!stack.isEmpty())
//            sb.append(stack.pop());
//        sb.reverse();

       while(sb.length()>1&&sb.charAt(0)=='0'){
           sb = sb.deleteCharAt(0);
       }
       return sb.toString();

    }
}
