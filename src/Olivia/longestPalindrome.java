package src.Olivia;


//NO 5
//String

public class longestPalindrome {
    int max;
    int index;
    public String longestPalindrome(String s) {
        //corner case
        if(s==null||s.length()<=1) return s;
        max = 1;
        index = 0;
        for(int i=0;i<s.length()-1;i++){
            //if it is odd
            paliHelper(s,i,i);
            //if it is even
            paliHelper(s,i,i+1);
        }
        return s.substring(index,index+max);
    }
    private void paliHelper(String s, int start1, int start2){
        while(start1>=0&&start2<s.length()&&s.charAt(start1)==s.charAt(start2)){
            start1--;
            start2++;
        }
        max = Math.max(start2-start1-1,max);
        index = max==start2-start1-1? start1+1 : index;
    }
}
