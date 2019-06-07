package src.Olivia;

import java.util.ArrayList;
import java.util.List;

//NO 241
//tree

public class diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
                char tmp = input.charAt(i);
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> result1 = diffWaysToCompute(part1);
                List<Integer> result2 = diffWaysToCompute(part2);
                for(int a1: result1){
                    for(int a2:result2){
                        if(tmp=='-'){
                            result.add(a1-a2);
                        }
                        if(tmp=='+'){
                            result.add(a1+a2);
                        }
                        if(tmp=='*'){
                            result.add(a1*a2);
                        }
                    }
                }

            }
        }
        if(result.size()==0) result.add(Integer.valueOf(input));
        return result;

    }
}
