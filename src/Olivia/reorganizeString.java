package src.Olivia;


//NO 767

public class reorganizeString {
    public String reorganizeString(String S) {
        int[] map = new int[26];
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a']++;
        }
        //find the max amount letter
        int max = 0;
        int letter = 0;
        for(int i=0;i<26;i++){
            if(map[i]>max){
                max = map[i];
                letter = i;
            }
        }
        //if max>(S.length+1)/2 return ""
        if(max>(S.length()+1)/2) return "";
        //put the max letter into 0,2,....
        char[] res = new char[S.length()];
        int index = 0;
        while(map[letter]>0){
            res[index] = (char)('a'+ letter);
            index += 2;
            map[letter]--;
        }
        //put others into the rest
        for(int i=0;i<26;i++){
            while(map[i]>0){
                if(index>=S.length())
                    index = 1;
                res[index] = (char)('a'+i);
                map[i]--;
                index += 2;
            }
        }
        return String.valueOf(res);
    }
}
