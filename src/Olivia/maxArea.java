package src.Olivia;

//NO 11
//two pointers

import java.util.Map;

public class maxArea {
    public int maxArea(int[] height) {
        //corner case
        if(height.length==0) return 0;
        int start = 0;
        int end = height.length-1;
        int max = 0;
        while(start<=end){
            int cur = Math.min(height[start],height[end])*(end-start);
            max = Math.max(cur,max);
            if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
            }
        }
        return max;

    }
}
