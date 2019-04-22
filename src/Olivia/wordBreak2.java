package src.Olivia;

import java.util.*;

//NO 140 Hard
//try dfs
public class wordBreak2 {

    //some bugs only return one list
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> result = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        breakHelper(s,wordDict,result,0,set,"");
//        return result;
//    }
//    private boolean breakHelper(String s, List<String> wordDict, List<String> result, int startLoc,
//                             Set<Integer> set, String cur){
//        if(startLoc==s.length()){
//            result.add(cur);
//            return true;
//        }
//        //if set contains the one that cannot make it possible, return directly
//        if(set.contains(startLoc)){
//            return false;
//        }
//        for(int i= startLoc+1;i<=s.length();i++){
//            String tmp = s.substring(startLoc,i);
//            if(wordDict.contains(tmp)) {
//
//                if(!breakHelper(s, wordDict, result, i, set, cur.equals( "") ? tmp : cur + " " + tmp)){
//
//                    set.add(i);
//                }
//            }
//        }
//        set.add(startLoc);
//        return false;
//    }
    //Using DFS directly will lead to TLE,
    // just used HashMap to save the previous results to prune duplicated branches

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        return wordHelper(s,wordDict,new HashMap<String, List<String>>());

    }
    private List<String> wordHelper(String s, List<String> wordDict, Map<String,List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if(s.length()==0){
            result.add("");
            return result;
        }
        for(String dic:wordDict){
            if(s.startsWith(dic)){
                List<String> sublist = wordHelper(s.substring(dic.length()),wordDict,map);
                for(String sub:sublist){
                    result.add(dic + (sub.isEmpty()?"":" "+sub));
                }
            }
        }
        map.put(s,result);
        return result;
    }


}
