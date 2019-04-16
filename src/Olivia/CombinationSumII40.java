package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//NO 40
//Try using DFS

public class CombinationSumII40 {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> result = new ArrayList<>();
//        combinationHelper(candidates, target, result, new ArrayList<Integer>(), 0);
//        return result;
//    }
//
//    private void combinationHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int startLoc) {
//        if (target > 0) {
//            for (int i = startLoc; i < candidates.length; i++) {
//                while (i > startLoc && i < candidates.length && candidates[i] == candidates[i - 1]) {
//                    i++;
//                }
//                if (i == candidates.length) break;
//                cur.add(candidates[i]);
//                combinationHelper(candidates, target - candidates[i], result, cur, i + 1);
//                cur.remove(cur.size() - 1);
//            }
//
//        } else if (target == 0) {
//            result.add(new ArrayList<>(cur));
//        }
//    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length==0)
            return result;
        Arrays.sort(candidates);
        combinationHelper(candidates,target,0,result,new ArrayList<Integer>());
        return result;

    }
    private void combinationHelper(int[] candidates,int target, int startloc, List<List<Integer>> result, List<Integer> cur){
        if(target==0){
            //need use new Array to add new list
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if(target>0){
            for(int i =startloc;i<candidates.length;i++){
                //need to avoid the same number
                while (i>startloc&&i<candidates.length&&candidates[i]==candidates[i-1]){
                    i++;
                }
                if(i==candidates.length) break;
                cur.add(candidates[i]);
                combinationHelper(candidates,target-candidates[i],i+1,result,cur);
                cur.remove(cur.size()-1);}

        }
    }

}
