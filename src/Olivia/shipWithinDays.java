package src.Olivia;

//NO 1011
//binary search

public class shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int start = 0;
        int end = 0;
        for(int cur:weights){
            //start will be the max number in weights
            start = Math.max(start,cur);
            //end will be the sum of all weights, the max number
            end += cur;
        }
        //now, start will be the minimal number
        start = Math.max(end/D,start);
        //do binary search
        while(start<end){
            int mid = start + (end-start)/2;
            //the bag if the max == mid needs
            int bag = 1;
            int cur = 0;
            for(int tmp :weights){
                if(cur+tmp>mid){
                    bag++;
                    cur = 0;
                }
                cur += tmp;
            }
            if(bag>D){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}
