package src.Olivia;

//No.310 Try using BFS
//Start form leaf node degree = 1;
//delete the leaf nodes(put their degree=0)
//Then add new leaf until queue only have nodes connected with each other

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        //corner case
        if(n==1){
            result.add(0);
            return result;
        }
        // initial a degree array
        int[] degree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i< n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        //initial a queue
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i]==0){
                return result;
            }
            if(degree[i]==1){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){

            int size = queue.size();
            // initial result to empty in each level util the very last one
            result = new ArrayList<>();
            for(int i=0;i<size;i++){
                int cur = queue.remove();
                result.add(cur);
                degree[cur]--;
                for(int j=0;j<graph.get(cur).size();j++){
                    int next = graph.get(cur).get(j);
                    if(degree[next]==0) {
                        //continue 结束本次循环 break结束整个循环体
                        continue;}
                        if(degree[next]==2){
                            queue.add(next);
                    }
                    degree[next]--;
                }
            }

        }
        return result;


    }
}
