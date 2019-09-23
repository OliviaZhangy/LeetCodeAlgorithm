package src.Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr.length<=1) return res;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            min = Math.min(min,arr[i+1]-arr[i]);
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==min){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                res.add(list);
            }
        }
        return res;
    }
}
