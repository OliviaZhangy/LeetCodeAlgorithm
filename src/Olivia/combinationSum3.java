package src.Olivia;
//NO 216
//Try use DFS

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        combineHelper(k,n,result,new ArrayList<Integer>(),1);
        return result;
    }
    private void combineHelper(int k, int n, List<List<Integer>> result, List<Integer> cur,int startloc){
        if(k==0&&n==0){
            result.add(new ArrayList<Integer>(cur));
        }
        if(n<0) return;
        if (n > 0) {
            for(int i = startloc;i<=9;i++){
                    cur.add(i);
                    combineHelper(k-1,n-i,result,cur,startloc+i);
                    cur.remove(cur.size()-1);
            }
        }
    }
}

