package src.Olivia;

import java.util.*;

//NO 332
//graph

public class findItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> cur:tickets){
            if(!graph.containsKey(cur.get(0))){
                graph.put(cur.get(0),new PriorityQueue<String>());
                graph.get(cur.get(0)).add(cur.get(1));
            }
            else{
                graph.get(cur.get(0)).add(cur.get(1));
            }
        }
        List<String> result = new ArrayList<>();
        dfs("JFK",result,graph);
        return result;
    }
    private void dfs(String start,List<String> result,Map<String,PriorityQueue<String>> graph){
        while (graph.containsKey(start)&&!graph.get(start).isEmpty()){
            String destination = graph.get(start).poll();
            dfs(destination,result,graph);
        }
        result.add(0,start);
    }
}
