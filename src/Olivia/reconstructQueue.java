package src.Olivia;

//NO 406
//balanced bst

import java.util.*;

public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //insert the tallest people first, then insert the second tallest guy, then continue

        //be familiar with how to use the comparator
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[0]!=o2[0]? -o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> result = new ArrayList<>();
        for(int[] cur:people){
            //can inset key at cur[1]
            result.add(cur[1],cur);
        }
        //turn arraylist to array
        return result.toArray(new int[people.length][]);
    }
}
