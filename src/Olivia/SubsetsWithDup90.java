package Olivia;

import sun.misc.Sort;

//NO 90 Try use DFS

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
//            /* i needs to larger than startLoc */
//            if (i > startLoc && nums[i] == nums[i - 1])
//                continue;
//            tmp.add(nums[i]);
//            subsetHelper(nums, result, tmp, i + 1);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    //corner case
    if(nums.length==0) return result;
    List<Integer> cur = new ArrayList<>();
    Arrays.sort(nums);
    subsetHelper(nums,result,cur,0);
    return result;

}

    private void subsetHelper(int[]nums,List<List<Integer>> result,List<Integer> cur,int startLoc){
        result.add(new ArrayList<Integer>(cur));
        for(int i =startLoc;i<nums.length;i++){
            if(i>startLoc&&nums[i]==nums[i-1])
                continue;
            cur.add(nums[i]);
            subsetHelper(nums,result,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
