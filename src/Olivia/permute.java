package src.Olivia;

//NO 46
//recursion

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute {
    public List<List<Integer>> permute(int[] nums) {
        //corner case
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0) return result;
        permuteHelper(nums,new ArrayList<Integer>(),result);
        return result;
    }
    private void permuteHelper(int[] nums,List<Integer> cur, List<List<Integer>> result){
        //base case
      if(cur.size()==nums.length){
          result.add(new ArrayList<Integer>(cur));
          return;
      }
      for(int i=0;i<nums.length;i++){
          //if already exist, continue
          if(cur.contains(nums[i])) continue;
          else{
              cur.add(nums[i]);
              permuteHelper(nums,cur,result);
              cur.remove(cur.size()-1);
          }

      }
    }

}
