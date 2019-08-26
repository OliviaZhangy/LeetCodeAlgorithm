package src.Olivia;

import java.util.Arrays;
import java.util.HashMap;

public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        //corner case
        if(words.length==0) return res;
        int[] queries1 = Helper(queries);
        int[] words1 = Helper(words);
        System.out.println(Arrays.toString(queries1));
        System.out.println(Arrays.toString(words1));

        Arrays.sort(words1);

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<res.length;i++){
            if(map.containsKey(queries1[i])) res[i] = map.get(queries1[i]);
            else{
                int count = 0;
                for(int j=words1.length-1;j>=0;j--){
                    if(queries1[i]<words1[j]){
                        count++;
                    }
                    else
                        break;
                }
                res[i] = count;
                map.put(queries1[i],count);
            }
        }
        return res;
    }
    private int[] Helper(String[] word){
        int[] res = new int[word.length];
        for(int i=0;i<word.length;i++){
            char[] arr = word[i].toCharArray();
            Arrays.sort(arr);
            char tmp = arr[0];
            int x = 0;
            while(x<arr.length&&arr[x]==tmp) {
                x++;
            }
            res[i] = x;
        }
        return res;
    }
   public static void main(String[] args){
        NumSmallerByFrequency q = new NumSmallerByFrequency();
       System.out.println(Arrays.toString(q.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
   }
}
