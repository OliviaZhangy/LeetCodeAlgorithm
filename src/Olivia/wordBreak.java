package src.Olivia;

//NO 139
//try dfs
//time exceeds first time

//Use a set to record all position that cannot find a match in dict.
// That cuts down the run time of DFS to O(n^2)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    //NOT GOOD SOLUTION TIME EXCEEDS
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if(breakHelper(s,wordDict)){
//            return true;
//        }
//        return false;
//    }
//    private boolean breakHelper(String s, List<String> wordDict){
//        if(s.length()==0){
//            return true;
//        }
//        for(int i=1;i<=s.length();i++){
//            if(wordDict.contains(s.substring(0,i))){
//             if(breakHelper(s.substring(i),wordDict)){
//                 return true;
//             }
//
//            }
//        }
//        return false;
//    }

    //arraylist的contain效率很低 换成hashset
    //记住了所有不可以完成的位置 减少了多次的运算

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        return dfs(s,wordDict,set,0);
    }
    private boolean dfs(String s, List<String> wordDict, Set<Integer> set, int startLoc){
        if(startLoc==s.length()){
            return true;
        }
        if(set.contains(startLoc)){
            return false;
        }
        for(int i= startLoc+1;i<=s.length();i++){
            String t = s.substring(startLoc,i);
            if(wordDict.contains(t)){
                if(dfs(s,wordDict,set,i)){
                    return true;
                }
                else{
                    set.add(i);
                }
            }
        }
        set.add(startLoc);
        return false;
    }
}
