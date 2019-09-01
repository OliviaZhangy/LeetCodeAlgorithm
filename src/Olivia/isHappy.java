package src.Olivia;

//NO 202
//two pointers

public class isHappy {
    public boolean isHappy(int n) {
        if(n==1) return true;
        int low = sum(n);
        int fast = sum(sum(n));
        while(low!=fast){
            low = sum(low);
            fast = sum(sum(fast));
        }
        return low==1;
    }
    private int sum(int n){
        int res = 0;
        int sum = 0;
        while(n>=10){
            res = n%10;
            sum += res*res;
            n  = n/10;
        }
        sum += n*n;
        return sum;
    }
}
