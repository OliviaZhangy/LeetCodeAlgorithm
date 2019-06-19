package src.Olivia;

//NO 253
//interval

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda


public class minMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        //corner case
        if(intervals==null||intervals.length==0) return 0;
        if(intervals.length==1) return 1;
        int room = 1;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endPointer = 0;
        for(int i=0;i<intervals.length;i++){
            //exist overlap
            if(start[i]<end[endPointer]){
                room++;
            }
            else{
                endPointer++;
            }
            }
            return room;
    }
}
