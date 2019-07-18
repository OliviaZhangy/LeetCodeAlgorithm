package src.Olivia;

//NO 670

public class maximumswap {
    public int maximumSwap(int num) {
        //corner case, only contains one number
        if(num>=0&&num<=9) return num;
        char[] digits = Integer.toString(num).toCharArray();
        int[] bucket = new int[10];

        //use bucket to store the last position of 0-9 in the num
        for(int i=0;i<digits.length;i++){
            bucket[digits[i]-'0'] = i;
        }

        for(int i=0;i<digits.length;i++){
            //if exists a number larger than the cur one and position is behind
            for(int j=9;j>=digits[i]-'0';j--){
                //if exists
                if(bucket[j]>i){
                    char tmp = digits[i];
                    digits[i] = digits[bucket[j]];
                    digits[bucket[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
