//package src.Olivia;
//
////NO 278
////search
//
//public class firstBadVersion {
//    boolean isBadVersion(int version);
//
//    public int firstBadVersion(int n) {
//        int start = 1;
//        int end = n;
//        while(start<end){
//            int mid = start + (end-start)/2;
//            if(!isBadVersion(mid)){
//                start = mid +1;
//            }
//            else{
//                end = mid;
//            }
//        }
//        return start;
//    }
//}
