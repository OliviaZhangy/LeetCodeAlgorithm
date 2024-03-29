package src.Olivia;

//NO 207
//graph
//could use topological sorting

import java.util.*;

public class canFinish {

    //could use matrix to represent the graph
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        //initial a matrix and an array
//        int[][] matrix = new int[numCourses][numCourses];
//        int[] degree = new int[numCourses];
//
//        for (int i=0;i<prerequisites.length;i++){
//            int post = prerequisites[i][0];
//            int pre = prerequisites[i][1];
//
//            degree[post]++;
//            matrix[pre][post] = 1;
//        }
//
//        int count = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i=0;i<numCourses;i++){
//            if(degree[i]==0){
//                queue.offer(i);
//            }
//        }
//        while(!queue.isEmpty()){
//            int course = queue.poll();
//            count++;
//            for(int i=0;i<numCourses;i++){
//                if(matrix[course][i]!=0){
//                    degree[i]--;
//                    if(degree[i]==0){
//                        queue.offer(i);
//                    }
//                }
//            }
//        }
//        return count==numCourses;
//    }

    //use adjacent list to represent graph
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] neigh = new LinkedList[numCourses];
//        Queue<Integer> queue = new LinkedList<>();
//        int[] indegree = new int[numCourses];
//        int count = 0;
//        for (int i = 0; i < numCourses; i++) neigh[i] = new LinkedList<>();
//        for (int[] pair : prerequisites) {
//            neigh[pair[1]].add(pair[0]);
//            indegree[pair[0]]++;
//        }
//        for (int i = 0; i < indegree.length; i++)
//            if (indegree[i] == 0) queue.offer(i);
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            count++;
//            for (int adj : neigh[course])
//                if (--indegree[adj] == 0) queue.offer(adj);
//        }
//        return count == numCourses;
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = 0;
        for(int[] cur:prerequisites){
            //cur[0] need a class to start
            indegree[cur[0]]++;
            if(!map.containsKey(cur[1]))
                map.put(cur[1],new ArrayList<>());
            map.get(cur[1]).add(cur[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        while (!que.isEmpty()){
            int course = que.poll();
            count++;
            if(map.containsKey(course)){
                List<Integer> list = map.get(course);
                for(int cur:list){
                    indegree[cur]--;
                    if(indegree[cur]==0){
                        que.add(cur);
                    }
                }
            }
        }
        return count==numCourses;
    }

}
