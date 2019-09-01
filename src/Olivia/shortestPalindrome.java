package src.Olivia;

//No 214
//two pointers

public class shortestPalindrome {
    public String shortestPalindrome(String s) {
        int j=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(j)==s.charAt(i)){
                j++;
            }
        }
        if(j==s.length()) return s;
        else{
            String suffix = s.substring(j);
            return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
        }
    }
}
