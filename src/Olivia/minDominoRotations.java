package src.Olivia;

//NO 1007
//google oa

public class minDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<len;i++){
            if(A[i]!=A[0]&&B[i]!=A[0])
                break;
            if(A[i]!=A[0])
                count1++;
            if(B[i]!=A[0])
                count2++;
            if(i==len-1)
                return Math.min(count1,count2);
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<len;i++){
            if(A[i]!=B[0]&&B[i]!=B[0])
                break;
            if(A[i]!=B[0])
                count1++;
            if(B[i]!=B[0])
                count2++;
            if(i==len-1)
                return Math.min(count1,count2);
        }
        return -1;

    }
}
