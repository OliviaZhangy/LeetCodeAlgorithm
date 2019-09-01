package src.Olivia;

public class dietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int res = 0;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += calories[i];
        }
        if(sum<lower) res--;
        if(sum>upper) res++;
        for(int i=1;i+k-1<calories.length;i++){

            sum  = sum + calories[i+k-1]-calories[i-1];
            if(sum<lower) res--;
            if(sum>upper) res++;

        }
        return res;
    }
}
