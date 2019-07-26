package src.Olivia;

import java.util.ArrayList;

//NO 986
public class intervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> res = new ArrayList<>();
        int m = A.length;
        int n = B.length;
        int p1 = 0;
        int p2 = 0;
        int start;
        int end;
        while(p1<m&&p2<n){

               start = Math.max(A[p1][0],B[p2][0]);
               end = Math.min(A[p1][1],B[p2][1]);
               if(end>=start){
                   int[] tmp = new int[2];
                   tmp[0] = start;
                   tmp[1] = end;
                   res.add(tmp);
               }
           if(end == A[p1][1]) p1++;
           else p2++;

        }
        return res.toArray(new int[res.size()][]);
    }
}
