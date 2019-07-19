package src.Olivia;

//NO 218

import java.util.*;

public class getSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        //to store the height
        List<int[]> height = new ArrayList<>();
        for(int[]node:buildings){
            //add height with left height turns to -height
            height.add(new int[]{node[0],-node[2]});
            //add height with right height
            height.add(new int[]{node[1],node[2]});
        }
        //sort the height from left to right, if it is equal, sort from low to high
        Collections.sort(height,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        //initial a queue to store the encounter height
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        //the very first height is 0
        queue.offer(0);
        int preMax = 0;
        for(int[]cur:height){
            if(cur[1]<0){
                //if encounter the left side, add a new height to the queue
                queue.add(-cur[1]);
            }
            else{
                //means cur[1] height is over
                queue.remove(cur[1]);
            }
            int curHeight = queue.peek();
            //check whether encounter an rectangle
            if(curHeight!=preMax){
                List<Integer> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(curHeight);
                res.add(list);
                preMax = curHeight;
            }

        }
        return res;
    }
}
