package src.Olivia;

//NO 135
//others

public class candy {
    public int candy(int[] ratings) {
        //corner case
        if(ratings==null||ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        int count = 1;
        int pre = 1;
        int countDown = 0;
        for(int i=1;i<ratings.length;i++){
            //if this number is larger than the previous one or equal to
            if(ratings[i]>=ratings[i-1]){
                //no descending before
                if(countDown==0){
                    if(ratings[i]==ratings[i-1]) {
                        pre = 1;
                        count += pre;
                    }
                    else{
                        pre ++;
                        count += pre;
                    }
                }
                else{
                    //no need to change the pre
                    if(countDown<pre) {
                        count += (1+countDown)*countDown/2;
                    }
                    //need to change the pre
                    else {
                        count += (1+countDown)*countDown/2 + (countDown - pre)+1;
                    }
                    pre = ratings[i]==ratings[i-1]? 1:2;
                    count += pre;
                    countDown = 0;
                }
            }
            //if this number is less than the previous one
            else{
                countDown++;
            }
        }
        //if it is descending at last
        if(countDown>0){
            count += (1+countDown)*countDown/2;
            if(countDown>=pre){
                count += countDown-pre+1;
            }
        }
        return count;
    }
}
