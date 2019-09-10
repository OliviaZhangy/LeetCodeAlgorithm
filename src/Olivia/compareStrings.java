package src.Olivia;


//Google OA pro

public class compareStrings {
    public int[] compareStrings(String A, String B){
        String[] str1 = A.split(",");
        String[] str2 = B.split(",");
        int len1 = str1.length;
        int len2 = str2.length;
        int[] freq = new int[11];
        int[] res = new int[len2];
        for(String cur:str1){
            //if(cur.length() == 0) continue;
            int[] counts = new int[26];
            int minIndex = 26;
            for(char tmp:cur.toCharArray()){
                counts[tmp-'a']++;
                minIndex = Math.min(minIndex,tmp-'a');
            }
            int tmp_res = counts[minIndex];
            freq[tmp_res]++;
        }
        //store the frequency
        for(int i=1;i<11;i++){
            freq[i] += freq[i-1];
        }
        int index = 0;
        for(String cur:str2){
            int[] counts = new int[26];
            int minIndex = 26;
            for(char tmp:cur.toCharArray()){
                counts[tmp-'a']++;
                minIndex = Math.min(minIndex,tmp-'a');
            }
            int tmp_res = counts[minIndex];
            res[index++] = (tmp_res-1>=0)?freq[tmp_res-1]:0;
        }
        return res;
    }
}
