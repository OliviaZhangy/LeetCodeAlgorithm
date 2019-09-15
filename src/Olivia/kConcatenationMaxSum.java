package src.Olivia;

import java.util.ArrayList;

public class kConcatenationMaxSum{
    public int kConcatenationMaxSum(int[] arr, int k) {
        long res = 0;
        int mode = (int)Math.pow(10,9)+7;
        long onesum = 0;
        for(int cur:arr){
            onesum += cur;
        }
        //k==1
        if(k==1){
            long tmp = 0;
            for(int i=0;i<arr.length;i++){
                tmp += arr[i];
                res = Math.max(res,tmp);
                if(tmp<0) tmp = 0;
            }
            return (int)res;
        }

        //left + allMid + right
        if(onesum>0&&k>=2){
            long leftSum = 0;
            long rightSum = 0;
            long tmp = 0;
            for(int i=0;i<arr.length;i++){
                tmp += arr[i];
                leftSum = Math.max(leftSum,tmp);
            }
            tmp = 0;
            for(int i=arr.length-1;i>=0;i--){
                tmp += arr[i];
                rightSum = Math.max(rightSum,tmp);
            }
            res = Math.max(res,leftSum+rightSum+(k-2)*onesum);
        }

        //left+right
        long tmp = 0;
        for(int i=0;i<arr.length;i++){
            tmp += arr[i];
            res = Math.max(res,tmp);
            if(tmp<0) tmp = 0;
        }
        for(int i=0;i<arr.length;i++){
            tmp += arr[i];
            res = Math.max(res,tmp);
            if(tmp<0) tmp = 0;
        }

        return (int)(res%mode);
    }
    public static void main (String[] args){
        kConcatenationMaxSum test = new kConcatenationMaxSum();
        System.out.println(test.kConcatenationMaxSum(new int[]{1,2},3));
    }
}