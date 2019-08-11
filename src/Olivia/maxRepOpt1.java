package src.Olivia;

public class maxRepOpt1 {
    public int maxRepOpt1(String text) {
        //corner case
        if(text.length()<=1) return text.length();
        int[] alpha = new int[26];
        //scan the whole text
        for(Character cur: text.toCharArray()){
            alpha[cur-'a']++;
        }
        char[] tmp = text.toCharArray();
        int window = 1;
        for(int left = 0; left < text.length();left++){
               char tc = tmp[left];
               int right = left;
               int change = 0;
               int count = 0;
               while (right<text.length()&&(tc==tmp[right]||change==0)&&count<alpha[tc-'a']){
                   if(tc!=tmp[right])
                       change = 1;
                   count++;
                   right++;
               }
                window = Math.max(window,count);
        }
        return window;
    }
}
