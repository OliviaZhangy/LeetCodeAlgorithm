package src.Olivia;
//NO 769
//The basic idea is to use max[] array to keep track of the max value until the current position,
// and compare it to the sorted array (indexes from 0 to arr.length - 1).
// If the max[i] equals the element at index i in the sorted array, then the final count++.
public class maxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {

        int[] max = new int[arr.length];

        max[0] = arr[0];
        //calculate the max at current position
        for(int i=1;i<arr.length;i++){
            max[i] = Math.max(max[i-1],arr[i]);
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(max[i]==i)
                count++;
        }
        return count;
    }
}
