package src.Olivia;

//NO 1060
//Binary Search

public class missingElement {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            int tmp = nums[mid] - nums[left] - (mid - left);
            if (tmp >= k) {
                right =mid;
            } else {
                left = mid;
                k -= tmp;
            }
        }

        if (nums[left] + k >= nums[right]) {
            return nums[left] + k + 1;
        }
        return nums[left] + k;
    }
}
