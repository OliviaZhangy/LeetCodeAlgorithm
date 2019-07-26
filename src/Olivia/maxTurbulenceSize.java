package src.Olivia;

//NO 978

public class maxTurbulenceSize {
    //use increase and decrease to look at the length!!!
    public int maxTurbulenceSize(int[] A) {
        if(A.length<=1) return A.length;
        int max = 0;
        int increase = 1;
        int decrease = 1;
        for(int i=1;i<A.length;i++){
            if(A[i]<A[i-1]){
                decrease=increase+1;
                increase = 1;
                max = Math.max(max,decrease);
            }
            else if(A[i]>A[i-1]){
                increase = decrease+1;
                decrease = 1;
                max = Math.max(max,increase);
            }
            else{
                increase = 1;
                decrease = 1;
            }
        }
        return max;

    }
}
