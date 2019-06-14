package src.Olivia;

//NO 334
//Search LIS

public class increasingTriplet {

    //the same idea with lis
//    public boolean increasingTriplet(int[] nums) {
//        int[] tail = new int[nums.length];
//        int size = 0;
//        for(int x:nums){
//            int start = 0;
//            int end = size;
//            while(start!=end) {
//                int mid = start + (end - start) / 2;
//                if(tail[mid]<x){
//                  start = mid +1;
//                }
//                else{
//                   end = mid;
//                }
//            }
//            tail[start] = x;
//            if(start==size) size++;
//            if(size==3) return true;
//        }
//        return false;
//    }


    //another way
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for(int x :nums){
            if(x<=small){
                small = x;
            }
            else if(x<=big){
                big = x;
            }
            else{
                return true;
            }
        }
        return false;
    }

}
