package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//NO78 USING BACKTRACKING

public class Subsets78 {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums.length == 0)
//            return result;
//        Arrays.sort(nums);
//        subsetHelper(nums, result, new ArrayList<>(), 0);
//        return result;
//    }
//
//    private void subsetHelper(int[] nums, List<List<Integer>> result, List<Integer> tmp, int startLoc) {
//        result.add(new ArrayList<>(tmp));
//        for (int i = startLoc; i < nums.length; i++) {
//            tmp.add(nums[i]);
//            subsetHelper(nums, result, tmp, i + 1);
//            tmp.remove(tmp.size() - 1);
//        }
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        //corner case
        if(nums.length==0) return result;
        //need to sort nums first
        Arrays.sort(nums);
        subsetHelper(nums,result,cur,0);
        return result;
    }
    // a helper function to help find the subsets
    private void subsetHelper(int[] nums,List<List<Integer>> result, List<Integer> cur, int startLoc){
        result.add(new ArrayList<Integer>(cur));
        for(int i=startLoc;i<nums.length;i++){
            cur.add(nums[i]);
            subsetHelper(nums,result,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
