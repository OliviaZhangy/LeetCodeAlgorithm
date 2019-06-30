package src.Olivia;

//No 274
//others

public class hIndex1 {
    //bucket sort
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int len = citations.length;
        int[] bucket = new int[len+1];
        for(int cur:citations){
            if(cur>len)
                bucket[len]++;
            else{
                bucket[cur]++;
            }
        }
        int count = 0;
        for(int i=len;i>=0;i--){
            count += bucket[i];
            if(count>=i) return i;
        }
        return 0;
    }
}
