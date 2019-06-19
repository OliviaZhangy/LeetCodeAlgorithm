package src.Olivia;
//NO 50
//recursion

public class myPow {
        public double myPow(double x, int n) {
            //corner case
            if(n==0) return 1.0;
            if(n==1) return x;
            if(n<0) return 1.0/x*myPow(1.0/x,-n-1);
            if(n%2==0){
                double cur = myPow(x,n/2);
                return cur*cur;
            }
            else{
                double cur = myPow(x,n/2);
                return cur*cur*x;
            }
        }
}
