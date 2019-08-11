package src.Olivia;


//NO 1151
public class minSwaps {
    public int minSwaps(int[] data) {
        //corner case
        if(data.length==0) return 0;
        int count = 0;
        for(int i=0;i<data.length;i++){
            if(data[i]==1)
                count++;
        }
        int tmp = 0;
        //base case
        for(int i=0;i<count;i++){
            if(data[i]==1) tmp++;
        }
        int max = tmp;
        for(int i=1;i+count<=data.length;i++){
            if(data[i-1]==1) tmp--;
            if(data[i+count-1]==1) tmp++;
            max = Math.max(max,tmp);
        }
        return count-max;
    }
}
