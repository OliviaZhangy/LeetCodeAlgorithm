package src.Olivia;

//NO 1057

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class assignBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] choose = new int[workers.length];
        Arrays.fill(choose,-1);
        //corner case
        if(workers==null||workers.length==0||bikes==null||bikes.length==0)
            return choose;
        //implement a priority queue
        PriorityQueue<int []> queue= new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1,int[]o2){
                if(o1[0]!=o2[0])
                {
                    return o1[0]-o2[0];
                }
                else{
                    if(o1[1]!=o2[1]){
                        return o1[1]-o2[1];
                    }
                    else{
                        return o1[2]-o2[2];
                    }
                }
            }
        });
        //add all distance to the queue
        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                int distance = Math.abs(workers[i][0]-bikes[j][0])+Math.abs(workers[i][1]-bikes[j][1]);
                queue.add(new int[]{distance,i,j});
            }
        }
        //need to check whether it is end or not
        HashSet<Integer> useBike = new HashSet<>();
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(choose[cur[1]]==-1&&!useBike.contains(cur[2])){
                choose[cur[1]] = cur[2];
                useBike.add(cur[2]);
                if(useBike.size()==workers.length)
                    return choose;
            }

        }
        return choose;

    }
}
