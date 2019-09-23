package src.Olivia;

import java.util.*;
//NO 1202
//Union Find

public class smallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //corner case
        if(s.length()==1) return s;
        int[] map = new int[s.length()];
        for(int i=0;i<s.length();i++){
            map[i] = i;
        }
        for(List<Integer>cur:pairs){
            unionFind(cur.get(0),cur.get(1),map);
        }
        for(int i=0;i<s.length();i++){
            map[i] = find(i,map);
        }
        HashMap<Integer,PriorityQueue<Character>> tmp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!tmp.containsKey(map[i])){
                tmp.put(map[i],new PriorityQueue<>());
            }
            tmp.get(map[i]).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(tmp.get(map[i]).poll());
        }
        return sb.toString();

    }
    private void unionFind(int x,int y,int[] map){
        x = find(x,map);
        y = find(y,map);
        if(x!=y){
            map[x] = y;
        }
    }
    private int find(int x,int[] map){
        if(map[x]==x) return x;
        else{
            map[x] = find(map[x],map);
            return map[x];
        }
    }
    public static void main(String[] args){
        smallestStringWithSwaps test = new smallestStringWithSwaps();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        cur.add(3);
        List<Integer> cur1 = new ArrayList<>();
        cur1.add(1);
        cur1.add(2);
        List<Integer> cur2 = new ArrayList<>();
        cur2.add(0);
        cur2.add(2);
        list.add(cur);
        list.add(cur1);
        list.add(cur2);
        System.out.println(test.smallestStringWithSwaps("dcab",list));
    }
}
