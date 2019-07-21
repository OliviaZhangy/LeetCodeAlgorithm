package src.Olivia;

//NO 957
//pattern

public class prisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] cur = cells;
        N = N%14;
        if(N==0) N=14;
        while(N>0){
            cur = flip(cur);
            N--;
        }
        return cur;
    }
    private int[] flip(int[] cells){
        int[] res = new int[cells.length];
        for(int i=1;i<=6;i++){
            if(cells[i-1]==cells[i+1]){
                res[i] = 1;
            }
        }
        return res;
    }
}
