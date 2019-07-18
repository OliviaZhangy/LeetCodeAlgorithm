package src.Olivia;

//NO 277

public class findCelebrity {
    private  boolean knows(int a, int b){return true;}
    public int findCelebrity(int n) {
        int cel = 0;
        for(int i=1;i<n;i++){
            if(knows(cel,i)){
                cel = i;
            }
        }
        //check cel is the true value
        for(int i=0;i<n;i++){
            if(i!=cel){
            if(!knows(i,cel)) return -1;
            if(knows(cel,i)) return -1;
            }
        }
        return cel;
    }
}
