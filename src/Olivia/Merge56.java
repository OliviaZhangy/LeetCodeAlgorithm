package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//NO 56
//interval

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Merge56 {


//    public List<Interval> merge(List<Interval> intervals) {
//        List<Interval> result = new ArrayList<>();
//        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
//        for (int i = 0; i < intervals.size(); i++) {
//            if (i > 0 && intervals.get(i).start >= result.get(result.size() - 1).start && intervals.get(i).start <= result.get(result.size() - 1).end) {
//                Interval cur = new Interval(Math.min(result.get(result.size() - 1).start, intervals.get(i).start), Math.max(result.get(result.size() - 1).end, intervals.get(i).end));
//                result.remove(result.size() - 1);
//                result.add(cur);
//            } else {
//                result.add(intervals.get(i));
//            }
//        }
//        return result;
//
//    }

    public int[][] merge(int[][] intervals) {
        //corner case
        if(intervals==null||intervals.length<=1) return intervals;

        //sort it by start point
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] cur:intervals){
            //if exists overlapping
            if(cur[0]<=newInterval[1]){
                newInterval[1] = Math.max(cur[1],newInterval[1]);
            }
            // if not exists overlapping
            else{
                newInterval = cur;
                result.add(newInterval);
            }

        }
        return result.toArray(new int[result.size()][]);



    }
}
