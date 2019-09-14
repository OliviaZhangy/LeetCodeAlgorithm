package src.Olivia;

//NO 1087

import java.util.TreeSet;

public class expand {
    public String[] expand (String S){
        TreeSet<String> set = new TreeSet<>();
//corner case
        if(S.length()==0) return new String[]{""};
        if(S.length()==1) return new String[]{S};

        if(S.charAt(0)=='{'){
            int j = 1;
            while(S.charAt(j)!='}'){j++;}
            String sub = S.substring(1,j);
            String[] subs = sub.split(",");
            String[] strs = expand(S.substring(j+1));
            for(int i=0;i<subs.length;i++){
                for(String str:strs){
                    set.add(subs[i]+str);
                }
            }

        }
        else{
            String[] strs = expand(S.substring(1));
            for(String str:strs){
                set.add(S.charAt(0)+str);
            }
        }
        return set.toArray(new String[0]);
    }

}
