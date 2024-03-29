package Olivia;

//NO.77
//Try using BFS

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> result = new ArrayList<>();
//        combineHelper(n, k, result, new ArrayList<>(), 1);
//        return result;
//    }
//
//    private void combineHelper(int n, int k, List<List<Integer>> result, List<Integer> tmp, int startLoc) {
//        if (k == 0) {
//            result.add(new ArrayList<>(tmp));
//        }
//        for (int i = startLoc; i <= n; i++) {
//            tmp.add(i);
//            /* Be careful about how to recursive */
//            combineHelper(n, k - 1, result, tmp, i + 1);//startLoc should be i+1 rather than startLoc+1
//            tmp.remove(tmp.size() - 1);
//        }
//    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        //corner case
        if(n==0||k==0){
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        combineHelper(n,k,result,cur,1);
        return result;

}
//a helper function to help find the combination
    private void combineHelper(int n, int k, List<List<Integer>> result, List<Integer> cur,int startLoc){
        if (k==0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = startLoc;i<=n;i++){
            cur.add(i);
            combineHelper(n,k-1,result,cur,i+1);
            cur.remove(cur.size()-1);

        }


    }

}

