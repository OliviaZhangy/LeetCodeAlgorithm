package src.Olivia;

//NO 753
//backtracking
//de Bruijn sequence of order 

import java.util.HashSet;

public class crackSafe {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("0");
        }
        HashSet<String> set = new HashSet<>();
        set.add(sb.toString());
        int nums = (int)Math.pow(k,n);
        dfsHelper(sb,set,nums,n,k);
        return sb.toString();
    }
    private boolean dfsHelper(StringBuilder sb, HashSet<String> set,int nums,int n,int k){
        if(set.size()==nums){
            return true;
        }
        String lastDigits = sb.substring(sb.length()-n+1);
        for(char i='0';i<'0'+k;i++){
            String now = lastDigits + i;
            if(!set.contains(now)){
                set.add(now);
                sb.append(i);
                if(dfsHelper(sb,set,nums,n,k)){
                    return true;
                }
                set.remove(now);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}
