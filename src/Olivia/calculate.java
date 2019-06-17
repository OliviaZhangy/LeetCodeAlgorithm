package src.Olivia;

//NO 227
//stack

import java.util.Stack;

public class calculate {
    public int calculate(String s) {
        //corner case
        if(s==null||s.length()==0) return 0;
        Stack<Integer> stack  = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            //if it is a number
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
            }
            //do not forget the last element
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==s.length()-1){
                if(sign=='+'){
                    stack.add(num);
                }
                else if(sign=='-'){
                    stack.add(-num);
                }
                else if(sign=='*'){
                    int tmp = stack.pop();
                    stack.add(tmp*num);
                }
                else if(sign=='/'){
                    int cur = stack.pop();
                    stack.add(cur/num);
                }
                sign = s.charAt(i);
                num = 0;
            }

        }
        int result = 0;
        for(int x: stack){
            result += x;
        }
        return result;
    }
}
