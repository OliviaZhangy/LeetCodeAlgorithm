package src.Olivia;

//NO320
//try dfs

import java.util.ArrayList;
import java.util.List;

public class generateAbbreviations {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        if(word.length()==0){
            result.add(word);
            return result;}
        generateHelper(word,result,0,"",false);
        return result;
    }
    private void generateHelper (String word, List<String> result,int startloc, String cur,boolean flag){

        if(startloc>=word.length()){
            result.add(cur);
            return;
        }
        int num = word.length();
        //flag indicate whether can be abbreviate, this round do not abbreviate
        if(!flag){
            for(int len=1;len+startloc<=num;len++){
                generateHelper(word,result,startloc+len,cur+len,true);
            }
        }
        generateHelper(word,result,startloc+1,cur+word.charAt(startloc),false);
    }
}
