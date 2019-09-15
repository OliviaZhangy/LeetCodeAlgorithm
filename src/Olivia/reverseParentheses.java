package src.Olivia;

public class reverseParentheses {
    public String reverseParentheses(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') count++;
        }
        //corner case
        if(count==0) return s;

        int pointer = 0;
        while (count>0){
            if(s.charAt(pointer)=='('){
                count--;
            }
            pointer++;
        }
        int endPoint = pointer;
        while(s.charAt(endPoint)!=')'){
            endPoint++;
        }
        //reverse from pointer to endPoint
        String tmp = "";
        if(pointer > 1){
            tmp += s.substring(0,pointer-1);
        }
        tmp += reverse(s,pointer,endPoint);
        if(endPoint<s.length()-1){
            tmp += s.substring(endPoint+1);
        }
        return reverseParentheses(tmp);
    }
    private String reverse(String s, int i,int j){
        StringBuilder tmp = new StringBuilder();
        tmp.append(s.substring(i,j));
        tmp.reverse();
        return tmp.toString();
    }
    public static void main(String[] args){
        reverseParentheses test = new reverseParentheses();
        System.out.println(test.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
