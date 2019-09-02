package src.Olivia;

import java.util.ArrayList;
import java.util.List;

//NO 254
public class getFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=3) return res;
        Helper(res,new ArrayList<>(),2,n);
        return res;
    }
    private void Helper(List<List<Integer>> res,List<Integer> cur, int start, int n){
        if(n<=1){
            if(cur.size()>1)
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start;i<=n;i++){
            if(n%i==0){
                cur.add(i);
                Helper(res,cur,i,n/i);
                cur.remove(cur.size()-1);
            }
        }

    }
}
