package src.Olivia;

//NO 242
//string

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int len = s.length();
        int[] visit = new int[26];
        for(int i = 0;i<len;i++){
            visit[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<len;i++){
            visit[t.charAt(i)-'a']--;
            if(visit[t.charAt(i)-'a']<0) return false;
        }
        return true;

    }
}
