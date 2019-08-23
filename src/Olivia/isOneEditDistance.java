package src.Olivia;

//NO 161


public class isOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        //if insert
       int len1 = s.length();
       int len2 = t.length();
       if(Math.abs(len1-len2)>=2) return false;
       if(len1==len2) return isOneReplace(s,t);
       if(len1>len2) return isOneDelete(s,t);
       return isOneDelete(t,s);
    }
    private boolean isOneReplace(String s,String t){
        int dif = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                dif++;
            }
        }
        return dif==1;
    }
    private boolean isOneDelete(String s, String t){
        for(int i=0,j=0;i<s.length()&&j<t.length();i++,j++){
            if(s.charAt(i)!=t.charAt(j)){
                return s.substring(i+1).equals(t.substring(j));
            }
        }
        return true;
    }
}
