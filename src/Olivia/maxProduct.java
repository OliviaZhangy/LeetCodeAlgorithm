package src.Olivia;

//NO 318
//bit manipulation

public class maxProduct {
    public int maxProduct(String[] words) {
        if(words==null||words.length==0) return 0;
        //like a map to store each word pattern
        int[] value = new int[words.length];
        int p = 0;
        for(String cur:words){
            value[p] = 0;
            for(int j=0;j<cur.length();j++){
                // because integer has 32 bit, so abc = 111
                value[p] |=1<<(cur.charAt(j)-'a');
            }
            p++;
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }
}
