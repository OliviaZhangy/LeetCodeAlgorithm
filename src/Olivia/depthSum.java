package src.Olivia;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class depthSum {
    public int depthSum(List<NestedInteger> nestedList) {
        //corner case
        if(nestedList==null){
            return 0;
        }
        //use a helper function to calculate the sum
        int sum = 0;
        int level = 1;
        return sumHelper(nestedList,sum,level);

    }
    private int sumHelper(List<NestedInteger> nestedList, int sum, int level){
        int len = nestedList.size();
        for(int i=0; i<len;i++){
            //Need to first get NestedInteger out from the list, then looking at whether it is integer or not
            NestedInteger cur = nestedList.get(i);
            if(cur.isInteger()){
                sum += level*cur.getInteger();
            }
            else{
                sum = sumHelper(cur.getList(),sum,level+1);
            }
        }
        return sum;
    }
}
