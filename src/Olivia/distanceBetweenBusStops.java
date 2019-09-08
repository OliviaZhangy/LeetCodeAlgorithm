package src.Olivia;

public class distanceBetweenBusStops {
    //[7,10,1,12,11,14,5,0]
    //7
    //2

    //->17
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start>destination){
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int sum = 0;
        int count1 = 0;
        for(int i=0;i<distance.length;i++){
            if(i>=start&&i<=destination-1){
                count1 += distance[i];
            }
            sum += distance[i];
        }
        if(count1<sum/2){
            return count1;
        }
        else
            return sum-count1;
    }
}
