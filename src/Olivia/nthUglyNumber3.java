package src.Olivia;


//NO 1201
//https://leetcode.com/problems/ugly-number-iii/discuss/387780/Java-Binary-Search-Venn-Diagram-Explain-Math-Formula
//Binary Search
//Calculate how many numbers from 1 to num are divisible by either a, b or c by using the formula:
//(num / a) + (num / b) + (num / c) – (num / lcm(a, b)) – (num / lcm(b, c)) – (num / lcm(a, c)) + (num / lcm(a, b, c))

public class nthUglyNumber3 {
    //greatest common divisor, b>=a
    private long gcd(long a, long b){
        if(a==0) return b;
        else return gcd(b%a,a);
    }
    //least common multiple
    private long lcm(long a,long b){
        return a*b/(gcd(a,b));
    }
    //calculate the count of num
    private int count(int num,int a, int b, int c){
        return (int) (num/a + num/b + num/c
                        - num/lcm(a,b)-num/lcm(b,c)-num/lcm(a,c)
                        + num/lcm(a,lcm(b,c)));
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int res = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            int count = count(mid,a,b,c);
            //do not just return mid, but to minimum the space
            if(count>=n) {
                res = mid;
                right = mid-1;
            }
            else{
              left = mid+1;
            }
        }
        return res;
    }
}
