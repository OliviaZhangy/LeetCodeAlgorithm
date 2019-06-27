package src.Olivia;

//NO 66
//others

import javax.xml.transform.Result;

public class plusOne {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0) return null;
        digits[digits.length-1]++;
        int count = 0;
        for(int i=digits.length-1;i>=0;i--){
            int cur = digits[i] +count;
            digits[i] = cur%10;
            count = cur/10;
        }
        if(count==0) {return digits;}

        else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }

            return result;
        }
    }
}
