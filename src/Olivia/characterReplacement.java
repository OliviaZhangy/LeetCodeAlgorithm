package src.Olivia;


//NO 424
//two pointers :sliding window
//First max the window size, then move the window based on the

public class characterReplacement {
    public int characterReplacement(String s, int k) {
        int[] store = new int[26];
        int maxCount = 0;
        int result = 0;
        int from = 0;
        for(int i=0;i<s.length();i++){
            store[s.charAt(i)-'A']++;
            maxCount = Math.max(maxCount,store[s.charAt(i)-'A']);
            //max the window size
            while(i-from-maxCount+1>k){
                store[s.charAt(from)-'A']--;
                from++;
            }
            result = Math.max(result,i-from+1);
        }
        return result;
    }
}
