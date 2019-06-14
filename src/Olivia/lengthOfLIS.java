package src.Olivia;

//NO 300
//search
//https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new  int[nums.length];
        int size = 0;
        for(int x:nums){
          int start = 0;
          int end = size;
          while(start!=end){
              int mid = start +(end-start)/2;
              if(tails[mid]<x){
                  start = mid + 1;
              }
              else{
                  end = mid;
              }
          }
              tails[start] = x;
              if(start==size) size++;

        }
        return size;

    }

}
