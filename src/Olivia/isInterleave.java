package src.Olivia;

//NO 97

public class isInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        //corner case
        if(len3!=(len1+len2)) return false;
        boolean[][] isInter = new boolean[len1+1][len2+1];
        //base case
        isInter[0][0] = true;
        for(int i=1;i<=len1;i++){
            isInter[i][0] = isInter[i-1][0]&&(s3.charAt(i-1)==s1.charAt(i-1));
        }
        for(int i=1;i<=len2;i++){
            isInter[0][i] = isInter[0][i-1]&&(s3.charAt(i-1)==s2.charAt(i-1));
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
               isInter[i][j] = ((isInter[i-1][j]&& (s1.charAt(i-1)==s3.charAt(i+j-1))))
                       || (isInter[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return isInter[len1][len2];

    }
}
