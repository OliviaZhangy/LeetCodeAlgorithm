package src.Olivia;

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        String cur = "";
        if(s==null||s.length()==0) return cur;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int num = 0;

        for(int i=0;i<s.length();i++){
            //when it is a number
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) -'0';
            }
            //when encounter '[' ,push num into count stack
            else if(s.charAt(i)=='['){
              countStack.add(num);
              num = 0;
              stringStack.add(cur);
              cur = "";
            }
            //when encounter ']', pop the number form string stack and repeat k times which is in count stack
            else if(s.charAt(i)==']'){
                int repeat = countStack.pop();
                StringBuilder tmp = new StringBuilder(stringStack.pop());
                while(repeat>0){
                    tmp.append(cur);
                    repeat--;
                }
                cur = tmp.toString();
            }
            //if it is a char
            else{
                cur += s.charAt(i);
            }
        }
        return cur;
    }
}
