package src.Olivia;

import java.util.*;

//NO 399
//union find
// using graph
//Image a/b = k as a link between node a and b, the weight from a to b is k,
// the reverse link is 1/k. Query is to find a path between two nodes.

public class calcEquation {
    class Edge{
        String to;
        double weight;
        Edge(String to,double weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Edge>> map = new HashMap<>();
        int i = 0;
        for(List<String> cur:equations){
            String from = cur.get(0);
            String to = cur.get(1);
            //put from -> to values[i]
            if(map.containsKey(from)){
                map.get(from).add(new Edge(to,values[i]));
            }
            else{
                map.put(from,new ArrayList<Edge>());
                map.get(from).add(new Edge(to,values[i]));
            }
            //put to->from 1/value[i]
            if(map.containsKey(to)){
                map.get(to).add(new Edge(from,1.0/values[i]));
            }
            else{
                map.put(to,new ArrayList<Edge>());
                map.get(to).add(new Edge(from,1.0/values[i]));
            }
            i++;
        }
        double[] result =  new double[queries.size()];
        int j = 0;
        double tmp = 1.0;

        for(List<String> cur: queries){
            String start = cur.get(0);
            String end = cur.get(1);
            Set<String> isVisited = new HashSet<>();
            isVisited.add(start);
            result[j] = getValue(start,end,map,tmp,isVisited);
            j++;
        }
        return result;
    }

    private double getValue(String start, String end, Map<String,List<Edge>> map,double tmp,Set<String> isVisited){
        //no match
        if(!map.containsKey(start)) return -1.0;
        if(start.equals(end)) return tmp;
        List<Edge> cur = map.get(start);
        for(Edge now:cur){
            if(!isVisited.contains(now.to)){
                isVisited.add(now.to);
                double result = getValue(now.to,end,map,tmp*now.weight,isVisited);
                if(result!=-1.0) return result;
            }
        }
        return -1.0;
    }
}
