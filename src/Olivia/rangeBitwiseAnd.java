package src.Olivia;

//NO 201
//bit manipulation

//last bit of (odd number & even number) is 0.
// when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
// Move m and n right a position.

//it is like find the prefix

public class rangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        //corner case
        if(m==0) return 0;
        int move =1;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            move <<= 1;
        }
        return m*move;
    }
}
