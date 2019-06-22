package src.Olivia;

//338
//bit manipulation

public class countBits {
    public int[] countBits(int num) {
       int[] result = new int[num+1];
       for(int i=1;i<result.length;i++){
           result[i] = result[i>>1] + (i&1);
       }
       return result;
    }
}
