package src.Olivia;

//NO 93 Try use DFS

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        ipHelper(s,result,0,"",0);
        return result;
    }
    //use count to count number of addresses

    private void ipHelper (String s, List<String> result, int startLoc, String cur,int count){
        if(count==4){
            if(startLoc==s.length()){
                result.add(cur);
            }
            return;
        }
        if(startLoc==s.length()) return;
        //try add one number, two numbers and three numbers
        //substring endloc do not contain the number so it is <=
        for(int i = 1;startLoc+i<=s.length()&&i<=3;i++){
            String tmp = s.substring(startLoc,startLoc+i);
            int number = Integer.valueOf(tmp);
            if(number>255||tmp.charAt(0)=='0'&&tmp.length()>1) break;

            ipHelper(s,result,startLoc+i,cur.isEmpty()?tmp:cur+"."+tmp,count+1);
        }
    }
}
