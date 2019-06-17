package src.Olivia;

//NO 71
//stack

import java.util.Stack;

public class simplifyPath {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        for(String x:path.split("/")){
            if(x.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(!x.equals("")&&!x.equals(".")){
                stack.push(x);
            }
        }
        if(stack.isEmpty()) return sb.append("/").toString();
       for(String x:stack){

            sb.append("/"+x);
        }

        return sb.toString();
    }
}
