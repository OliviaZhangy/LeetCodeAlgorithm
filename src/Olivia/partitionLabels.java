package src.Olivia;

import java.util.*;
//it is an interval problem
//the best way to solve it is two pointers
//NO 763

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
            List<Integer> res = new ArrayList<>();
            //corner case
            if(S==null||S.length()==0) return res;
            Set<Character> setChar = new HashSet<>();
            Set<int[]> set = new TreeSet<int[]>(new Comparator<int[]>(){
                public int compare(int[] o1,int[] o2){
                    return o1[0]-o2[0];
                }
            } );
            for(int i=0;i<S.length();i++){
                char cur = S.charAt(i);
                if(!setChar.contains(cur)){
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = S.lastIndexOf(cur);
                    setChar.add(cur);
                    set.add(tmp);
                }
            }
            int min = 0;
            int max = 0;
            for(int[] tmp : set){
                if(tmp[1]<max) continue;
                if(tmp[0]>max){
                    res.add(max-min+1);
                    max = tmp[1];
                    min = tmp[0];
                }
                if(tmp[1]>max){
                    max = tmp[1];
                }
            }
            res.add(max-min+1);
            return res;
        }

}
