package src.Olivia;

import java.util.ArrayList;
import java.util.List;

//NO 301 Hard
//try dfs
//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
public class removeInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String>  result = new ArrayList<>();

        removeHelper(s,result,0,0,new char[]{'(',')'});
        return result;

    }
    private void removeHelper(String s, List<String> result,  int startLoc, int last_j, char[] pair){
        for(int stack=0,i=startLoc;i<s.length();i++){
            if(s.charAt(i)==pair[0]) stack++;
            if(s.charAt(i)==pair[1]) stack--;
            if(stack>=0) continue;
            //if stack <0 means need to remove pair[1]
            for(int j=last_j;j<=i;j++){
                if(s.charAt(j)==pair[1]&&(j==last_j||s.charAt(j-1)!=pair[1])){
                    removeHelper(s.substring(0,j)+s.substring(j+1,s.length()),result,i,j,pair);
                }

            }
            //return should be at right place.
            return;
        }
        String reversd = new StringBuilder(s).reverse().toString();
        //finished from left to right, tricky part use the code again!
        if(pair[0]=='('){
            removeHelper(reversd,result,0,0,new char[]{')','('});
        }
        //finished from right to left
        else{
            result.add(reversd);
        }

    }
}
