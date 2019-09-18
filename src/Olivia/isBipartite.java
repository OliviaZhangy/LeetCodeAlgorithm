package src.Olivia;


//NO 785

//coloring problem

public class isBipartite {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        //color each node, if = 1 blue, =-1 red ,=0 no color yet
        int[] color = new int[len];
        color[0] = 1;
        for(int i=0;i<len;i++){
            if(!color(graph,i,color)) return false;
        }
        return true;
    }
    private boolean color(int[][] graph, int i,int[] color){
        int[] connect = graph[i];
        int colorRoot = color[i];
        if(colorRoot==0){
            for(int j=0;j<connect.length;j++){
                if(connect[j]!=0){
                    colorRoot = -connect[j];
                    break;
                }
            }
        }
        if(colorRoot==0){
            colorRoot = 1;
        }
        //color the children
        for(int j=0;j<connect.length;j++){
            if(color[connect[j]]==0) color[connect[j]] = -colorRoot;
            //cause problem
            else if(color[connect[j]]==colorRoot) return false;
        }
        return true;
    }
}
