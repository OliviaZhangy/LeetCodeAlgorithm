package Olivia;

import java.util.ArrayList;
import java.util.List;

//NO39 Try using DFS

public class CombinationSum39 {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        combinationHelper(result, candidates, target, new ArrayList<Integer>(), 0);
//        return result;
//    }
//
//    private void combinationHelper(List<List<Integer>> result, int[] candidates, int target, List<Integer> cur, int startLoc) {
//        if (target > 0) {
//
//            //should begin with the startLoc to avoid duplication
//            for (int i = startLoc; i < candidates.length; i++) {
//                cur.add(candidates[i]);
//                combinationHelper(result, candidates, target - candidates[i], cur, i);
//
//                //to go through all possibilities
//                cur.remove(cur.size() - 1);
//            }
//        } else if (target == 0) {
//
//            //should add new arrarylist not cur
//            result.add(new ArrayList<Integer>(cur));
//        }
//
//    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //corner case
        if(candidates.length==0)
            return result;
        combineHelper(candidates,target,0,new ArrayList<Integer>(),result);
        return result;
    }
    private void combineHelper(int[] candidates, int target, int startloc, List<Integer> cur,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if(target>0){
            for(int i = startloc;i<candidates.length;i++){
                //choose candidate[i]
                cur.add(candidates[i]);
                combineHelper(candidates,target-candidates[i],i,cur,result);
                //Do not forget to get cur back
                cur.remove(cur.size()-1);
            }
        }
    }
}
