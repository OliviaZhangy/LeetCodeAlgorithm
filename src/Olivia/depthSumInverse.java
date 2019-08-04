//package src.Olivia;
//
////NO.364
////Using BFS
////Each level add one time and add former level one more time
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * // This is the interface that allows for creating nested lists.
// * // You should not implement it, or speculate about its implementation
// * public interface NestedInteger {
// *     // Constructor initializes an empty nested list.
// *     public NestedInteger();
// *
// *     // Constructor initializes a single integer.
// *     public NestedInteger(int value);
// *
// *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
// *     public boolean isInteger();
// *
// *     // @return the single integer that this NestedInteger holds, if it holds a single integer
// *     // Return null if this NestedInteger holds a nested list
// *     public Integer getInteger();
// *
// *     // Set this NestedInteger to hold a single integer.
// *     public void setInteger(int value);
// *
// *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
// *     public void add(NestedInteger ni);
// *
// *     // @return the nested list that this NestedInteger holds, if it holds a nested list
// *     // Return null if this NestedInteger holds a single integer
// *     public List<NestedInteger> getList();
// * }
// */
//
//public class depthSumInverse{
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        //corner case
//        if (nestedList == null)
//            return 0;
//        int sum = 0;
//        int curSum = 0;
//        Queue<NestedInteger> queue = new LinkedList<>();
//        queue.addAll(nestedList);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i=0;i<size;i++){
//                NestedInteger cur = queue.remove();
//                if(cur.isInteger){
//                    //add level one again and again
//                    curSum += cur.getInteger();
//                }
//                else{
//                    queue.addAll(cur.getList());
//                }
//            }
//            sum += curSum;
//        }
//        return sum;
//    }
//}
