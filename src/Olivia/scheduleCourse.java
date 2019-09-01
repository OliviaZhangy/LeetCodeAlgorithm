package src.Olivia;


//NO 630

import java.util.Arrays;
import java.util.PriorityQueue;

public class scheduleCourse {
    public int scheduleCourse(int[][] courses) {
        //sort all the courses by the end time
        Arrays.sort(courses,(a,b)->(a[1]-b[1]));

        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for(int[] cur:courses){
            time += cur[0];
            que.add(cur[0]);
            if(time>cur[1]){
                //delete the course which course the most time
                time-= que.poll();
            }
        }
        return que.size();
    }
}
