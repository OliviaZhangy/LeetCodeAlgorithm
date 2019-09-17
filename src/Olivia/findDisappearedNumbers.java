package src.Olivia;

import java.util.ArrayList;
import java.util.List;


//NO 448
public class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int tmp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                tmp = -nums[i];
            }
            else{
                tmp = nums[i];
            }
            if(nums[tmp-1]>0) nums[tmp-1] = -nums[tmp-1];
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
