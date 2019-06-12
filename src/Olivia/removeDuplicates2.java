package src.Olivia;

//NO 80
//two pointers
// a little tricky

public class removeDuplicates2 {
    public int removeDuplicates(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) return 0;
        int pointer = 0;
        for (int n:nums) {
            if (pointer < 2 || n > nums[pointer - 2]) {
                nums[pointer] = n;
                pointer++;
            }
        }
        return pointer;
    }
}
