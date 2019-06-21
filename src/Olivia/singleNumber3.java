package src.Olivia;

//No 260
//bit manipulation

//[1,2,1,3,2,5]
// --> [3,5]

public class singleNumber3 {
    public int[] singleNumber(int[] nums) {
        int two = 0 ;
        int a = 0;
        int b = 0;
        int mask = 1;
        //two = a ^ b
        for(int cur: nums){
            two ^= cur;
        }
        //find one location different
        while((two&mask)==0){
            mask = mask<<1;
        }

        //group all numbers to two part
        for(int cur: nums){
            //not forget ()
            if((mask&cur)==0){
                a ^= cur;
            }
            else{
                b ^= cur;
            }
        }
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }
}
