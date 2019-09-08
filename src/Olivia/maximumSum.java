package src.Olivia;


//NO 1186
//Compute maxEndHere and maxStartHere arrays and also find overall max along with them.
// evaluate the case where 1-element can be elementated, that at each index,
// we can make use of maxEndHere[i-1]+maxStartHere[i+1]

public class maximumSum {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] maxEnd = new int[len];
        int[] maxStart = new int[len];
        int max = arr[0];
        maxEnd[0] = arr[0];
        for(int i=1;i<len;i++){
            maxEnd[i] = Math.max(maxEnd[i-1]+arr[i],arr[i]);
            max = Math.max(max,maxEnd[i]);
        }
        maxStart[len-1] = arr[len-1];
        for(int i=len-2;i>=0;i--){
            maxStart[i] = Math.max(arr[i],maxStart[i+1]+arr[i]);
        }
        for(int i=1;i<len-1;i++){
            max = Math.max(max,maxEnd[i-1]+maxStart[i+1]);
        }
        return max;
    }
}
