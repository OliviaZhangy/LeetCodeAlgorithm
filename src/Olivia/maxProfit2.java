package src.Olivia;

//NO 122
//try dp
//
public class maxProfit2 {
    public int maxProfit(int[] prices) {
        //corner case
        if(prices.length==0)
            return 0;
        int len = prices.length;

        int min = 0;
        int max = 0;
        int result = 0;
        int i = 0;
        //be careful about the restrictions
       while( i<len-1){
           while(i+1<len&&prices[i+1]<=prices[i]){
               i++;
           }
           min = prices[i];
           while(i+1<len&&prices[i+1]>prices[i]){
               i++;
           }
           max = prices[i];
           result += max-min;

        }
        return result;
    }
}
