package src.Olivia;

//NO 275
//search

public class hIndex {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int start = 0;
        int end = citations.length-1;
        int len = citations.length;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(citations[mid]==len-mid) return citations[mid];
            if(citations[mid]>(len-mid)){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        //pay attention to the last case
        //After iteration, it is guaranteed that start is the one we need to find
        // (i.e. len-start papars have at least len-start citations)
        return len-start;
    }
}
