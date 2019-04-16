package Olivia;

import java.util.ArrayList;
import java.util.List;
//NO 22
//Try using DFS

public class GenerateParenthesis22 {
//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        generateHelper(result, "", 0, 0, n);
//        return result;
//    }
//
//    private void generateHelper(List<String> result, String str, int left, int right, int max) {
//        if (str.length() == max * 2) {
//            result.add(str);
//            return;
//        }
//        if (left < max) {
//            generateHelper(result, str + "(", left + 1, right, max);
//        }
//        if (right < left) {
//            generateHelper(result, str + ")", left, right + 1, max);
//        }
//    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //corner case
        if(n==0){return result;}
        String str = "";
        generateHelper(n,result,0,0,str);
        return result;

    }
    //give a helper function to help generate parenthesis
    private void generateHelper(int n, List<String> result, int left, int right,String str){
        if(str.length()==2*n){
            result.add(str);
            return;
        }
        if(left<n){
            generateHelper(n,result,left+1,right,str+"(");
        }
        if(left>right){
            generateHelper(n,result,left,right+1,str+")");
        }
    }

}
