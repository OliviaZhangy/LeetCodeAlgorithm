package src.Olivia;
//No282 Hard
//try use dfs

import java.util.ArrayList;
import java.util.List;

public class addOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result  = new ArrayList<>();
        //CORNER CASE
        if(num.length()==0)
            return result;
        addHelper(num,target,result,"",0,0,0);
        return result;
    }
    private void addHelper (String num, int target,List<String> result, String cur,int startLoc,long now,long before){
        if(startLoc==num.length()){
            if(now == target){
                result.add(cur);
            }
            return;
        }
        for(int i=startLoc;i<=num.length();i++){
            //corner case: not allowed 023 exist
            if(i!=startLoc&&num.charAt(startLoc)=='0') break;
            // 	parseLong(String s)
            //Parses the string argument as a signed decimal long.
            long tmp = Long.parseLong(num.substring(startLoc,i+1));
            if(startLoc==0){
                addHelper(num,target,result,cur+tmp,i+1,tmp,tmp);

            }
            else{
                //use +
                addHelper(num,target,result,cur+"+"+tmp,i+1,now+tmp,tmp);
                //use -
                addHelper(num,target,result,cur+"-"+tmp,i+1,now-tmp,-tmp);
                //use *
                addHelper(num,target,result,cur+"*"+tmp,i+1,(now-before)+tmp*before,tmp*before);
            }
        }

    }

}
