package src.Olivia;

//NO 385
//stack

import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
   public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */



public class deserialize {
    public interface NestedInteger {
    public NestedInteger();
    public NestedInteger(int value);
    public boolean isInteger();
    public Integer getInteger();
    public void setInteger(int value);
    public void add(NestedInteger ni);
    public List<NestedInteger> getList();
    }


    public NestedInteger deserialize(String s) {
        //corner case
        if(s==null||s.length()==0) return null;
        if(s.charAt(0)!='[')
            return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        //start points to the start of the num
        int start = 0;
        for(int i=0;i<s.length();i++){
            //if encounter '[' push cur to stack and start a new one
            if(s.charAt(i)=='['){
                if(cur!=null){
                    stack.push(cur);
                }
                cur = new NestedInteger();
                start = i+1;
            }
            if(s.charAt(i)==']'){
               String num = s.substring(start,i);
               if(!num.isEmpty()) cur.add(new NestedInteger(Integer.valueOf(num)));
               if(!stack.isEmpty()){
                   NestedInteger pop = stack.pop();
                   pop.add(cur);
                   cur = pop;
               }
               start = i+1;
            }
            if(s.charAt(i)==','){
                if(s.charAt(i-1)!=']'){
                String num = s.substring(start,i);

                cur.add(new NestedInteger(Integer.valueOf(num)));}
                start = i+1;
            }
        }
        return cur;
    }
}
