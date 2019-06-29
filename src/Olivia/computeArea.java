package src.Olivia;

//NO 223
//others

public class computeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1 = (C-A)*(D-B);
        int rec2 = (G-E)*(H-F);
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        int overlap = 0;
        if(top>bottom&&left<right){
            overlap = (top-bottom)*(right-left);
        }
        return rect1+rec2-overlap;
    }
}
