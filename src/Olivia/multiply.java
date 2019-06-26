package src.Olivia;

//NO 43
//others


public class multiply {
    public String multiply(String num1, String num2) {
        //corner case
        if(num1.equals("0")||num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
       StringBuilder str = new StringBuilder();
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int p1 = i+j+1;
                int p2 = i+j;
                int multi = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                //need to take care of the origin number
                int sum = result[p1]+multi;
                result[p1] = sum%10;
                result[p2] += sum/10;
            }
        }
        for(int i=0;i<result.length;i++){
            if (i==0&&result[i]==0) continue;
            str.append(result[i]);
        }
        return str.length()==0?"0":str.toString();
    }
}
