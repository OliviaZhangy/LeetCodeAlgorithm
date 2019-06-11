package src.Olivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//NO 210
//graph

public class findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] neigh = new LinkedList[numCourses];
        int[] degree = new int[numCourses];
        //initialize
        for(int i=0;i<numCourses;i++){
            neigh[i] = new LinkedList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int post = prerequisites[i][0];
            int pre = prerequisites[i][1];
            neigh[pre].add(post);
            degree[post]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(degree[i]==0){
                queue.offer(i);
                result.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.remove();
            for(int adj:neigh[cur]){
                degree[adj]--;
                if(degree[adj]==0){
                    queue.offer(adj);
                    result.add(adj);
                }
            }
        }
        if(result.size()==numCourses){
            int[] res = new int[numCourses];
       for(int i=0;i<numCourses;i++){
           res[i] = result.get(i);
       }
        return res;}
        else return new int[0];

    }
}
