package src.Olivia;


//NO 777
public class canTransform {
    public boolean canTransform(String start, String end) {
        int left = 0;
        int right = 0;
        for(int i=0;i<start.length();i++){
            if(start.charAt(i)=='L') left++;
            if(start.charAt(i)=='R') right++;
            if(end.charAt(i)=='L') left--;
            if(end.charAt(i)=='R') right--;
            if(left>0||right<0||(left<0&&right!=0)||(right>0)&&(left!=0))
                return false;
        }
        return left==0&&right==0;
    }
}
