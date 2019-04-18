package src.Olivia;

import java.util.ArrayList;
import java.util.List;

//NO 301 Hard
//try dfs
//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
public class removeInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String>  result = new ArrayList<>();
        //corner case
        if(s.length()==0) return result;
        removeHelper(s,result,0,0,new char[]{'(',')'});
        return result;

    }
    private void removeHelper(String s, List<String> result,  int last_i, int last_j, char[] pair){
      for(int stack=0,i=last_i;i<s.length();i++){
          if(s.charAt(i)==pair[0]) stack++;
          if(s.charAt(i)==pair[1]) stack--;
          if(stack>=0) continue;
          for(int j=last_j;j<=i;j++){
              if(s.charAt(j)==pair[1]&&(j==last_j||s.charAt(j-1)!=pair[1])){
                  removeHelper(s.substring(0,j)+s.substring(j+1,s.length()),result,i,j,pair);
                  return;
              }
          }
      }
      String reversd = new StringBuilder(s).reverse().toString();
      if(pair[0]=='('){
          removeHelper(reversd,result,0,0,new char[]{')','('});
        }
        else{
            result.add(reversd);
      }

    }
}
