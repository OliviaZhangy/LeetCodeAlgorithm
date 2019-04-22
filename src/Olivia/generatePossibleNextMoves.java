package src.Olivia;

import java.util.ArrayList;
import java.util.List;

//NO 293

public class generatePossibleNextMoves {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(i-1>=0&&s.charAt(i-1)=='+'&&s.charAt(i)=='+'){
                result.add((i==1?"":s.substring(0,i-1))+"--"+s.substring(i+1));
            }
        }
        return result;
    }

}
