package src.Olivia;

//google oa
public class wateringPlantsSteps {
    public int wateringPlantsSteps(int[] flowers, int capacity) {
        //corner case
        if(flowers==null||flowers.length==0)
            return 0;
        int res = 0;
        int cur = capacity;
        for(int i=0;i<flowers.length;i++){
            if(capacity<flowers[i])
                return -1;
            //need to turn back
            if(cur<flowers[i]){
                res += 2*i;
                cur = capacity;
            }
            else{
                res++;
                cur = cur - flowers[i];
            }
            return res;
        }
    }
}
