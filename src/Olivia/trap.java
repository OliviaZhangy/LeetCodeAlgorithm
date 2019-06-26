package src.Olivia;

//NO 42
//others

public class trap {
    public int trap(int[] height) {
        //corner case
        if(height==null||height.length<=1) return 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<=right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);
            if(leftMax<rightMax){
                max += leftMax-height[left];
                left++;
            }
            else{
                max += rightMax-height[right];
                right--;
            }
        }
        return max;
    }
}
