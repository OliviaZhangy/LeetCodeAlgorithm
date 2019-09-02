package src.Olivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//NO 249

public class groupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String cur:strings){
            char[] arr = cur.toCharArray();
            StringBuilder sb = new StringBuilder();
            if(arr.length==1) sb = sb.append("a");
            for(int i=0;i+1<arr.length;i++){
                sb.append(arr[i+1]-arr[i]<0?arr[i+1]-arr[i]+26:arr[i+1]-arr[i]).append("->");
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(cur);
        }
        for(List<String>cur: map.values()){
            res.add(new ArrayList<>(cur));
        }
        return res;
    }
}
