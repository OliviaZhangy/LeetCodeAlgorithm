package src.Olivia;

//NO 475
//search

import java.util.Arrays;

public class findRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for(int x:houses){
            int index = Arrays.binarySearch(heaters,x);
            if(index<0){
                index = -index-1;
                int distance1 = index>0?x-heaters[index-1]:Integer.MAX_VALUE;
                int distance2 = index<heaters.length?heaters[index]-x:Integer.MAX_VALUE;
                result = Math.max(result,Math.min(distance1,distance2));
            }

        }
        return result;
    }
}
