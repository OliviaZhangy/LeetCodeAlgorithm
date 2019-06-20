package src.Olivia;

//NO 392
//greedy

public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(s.length()>t.length()) return false;
        int p1 = 0;
        for(int i = 0;i<t.length();i++){
            if(s.charAt(p1)==s.charAt(i)){
                p1++;
                if(p1==s.length()) return true;
            }
        }
        return false;
    }
}
