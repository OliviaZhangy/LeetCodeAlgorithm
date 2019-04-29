package src.Olivia;

//NO 395
//try dp

public class longestSubstring {
    public int longestSubstring(String s, int k) {
        //corner case
        if(s.length()==0)
            return 0;
        //initial an int[]
        int[] alph = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            alph[s.charAt(i)-'a']++;
        }
        boolean flag = true;
        for(int i = 0;i<26;i++){
            if(alph[i]>0&&alph[i]<k)
                flag = false;
        }
        if(flag) return len;
        int result = 0;
        int tmp = 0;
        int start = 0;
        while(tmp<len){
            if(alph[s.charAt(tmp)-'a']<k){
                result = Math.max(result,longestSubstring(s.substring(start,tmp),k));
                start = tmp+1;
            }
            tmp++;
        }
        result = Math.max(result,longestSubstring(s.substring(start),k));
        return result;

    }
}



