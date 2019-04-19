package src.Olivia;

import java.util.ArrayList;
import java.util.List;
//No 131
//try dfs

public class partition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        //corner case
        if(s.length()==0) return result;
        partHelper(s,result,new ArrayList<String>());
        return result;

    }
    //check whether it is a palindrome
    private boolean isPalin(String s){
        int len = s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1))
                return false;
        }
        return true;
    }

    // a helper function to add the suitable function
    private void partHelper(String s,List<List<String>> result, List<String> cur){
        if(s.length()==0){
            result.add(new ArrayList<String>(cur));
            return;
        }
        for(int i =1;i<=s.length();i++){
            if(isPalin(s.substring(0,i))){
                cur.add(s.substring(0,i));
                partHelper(s.substring(i),result,cur);
                cur.remove(cur.size()-1);
            }
        }

    }
}
