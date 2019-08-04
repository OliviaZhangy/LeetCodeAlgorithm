package src.Olivia;

//NO 84

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        // idx of the first bar the left that is lower than current
        int[] leftMin = new int[heights.length];
        // idx of the first bar the right that is lower than current
        int[] rightMin = new int[heights.length];
        leftMin[0] = -1;
        rightMin[heights.length-1] = heights.length;
        for(int i=1;i<heights.length;i++){
            int p=i-1;
            while (p>=0&&heights[p]>=heights[i]){
                p = leftMin[p];
            }
            leftMin[i] = p;
        }
        for(int i=heights.length-2;i>=0;i--){
            int p = i+1;
            while (p<heights.length&&heights[p]>=heights[i]){
                p = rightMin[p];
            }
            rightMin[i] = p;
        }
        int max = 0;
        for(int i=0;i<heights.length;i++){
            max= Math.max(max,heights[i]*(rightMin[i]-leftMin[i]-1));
        }
        return max;

    }
}
