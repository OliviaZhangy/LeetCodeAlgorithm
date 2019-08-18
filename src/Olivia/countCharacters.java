package src.Olivia;

//NO 1161
public class countCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for(int i=0;i<chars.length();i++){
            map[chars.charAt(i)-'a']++;
        }
        int res = 0;
        for(String word:words){
            int[] tmp = map.clone();
            if(isIn(word,tmp)){
                res += word.length();
            }
        }
        return res;
    }
    private boolean isIn(String word, int[] map){
        for(int i=0;i<word.length();i++){
            int tmp = word.charAt(i)-'a';
            map[tmp]--;
            if(map[tmp]<0) return false;
        }
        return true;
    }
}
