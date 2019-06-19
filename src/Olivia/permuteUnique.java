package src.Olivia;

//NO 47
//recursion

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//use a boolean to store already get or not

public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //corner case
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] isGet = new boolean[nums.length];
        permuteHelper(nums, new ArrayList<Integer>(), result,isGet);
        return result;
    }

    private void permuteHelper(int[] nums, List<Integer> cur, List<List<Integer>> result,boolean[] isGet) {
        //base case
        if (cur.size() == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //avoid duplicate, use the last one first
           if(isGet[i]||(i>0&&nums[i]==nums[i-1]&&!isGet[i-1]))
                continue;
            //use this number
            isGet[i] = true;
            cur.add(nums[i]);
            permuteHelper(nums,cur,result,isGet);
            isGet[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}


