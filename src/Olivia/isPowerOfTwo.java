package src.Olivia;
//No 231
//bit
public class isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0&&((n)&(n-1))==0;
    }
}
