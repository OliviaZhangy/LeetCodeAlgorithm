package src.Olivia;

//No 252
//interval

import java.util.Arrays;
import java.util.Comparator;

public class canAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        //corner case
        if(intervals==null||intervals.length<=1) return true;
        //sort by the start point
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }
}
