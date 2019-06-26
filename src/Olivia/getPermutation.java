package src.Olivia;

//NO 60
//others


import java.util.ArrayList;
import java.util.List;

public class getPermutation {
    //1 2 3
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();

        //construct a factorial int[]
        int[] factorial = new int[n+1];
        int sum = 1;
        //{1,1,2,6}
        factorial[0] = 1;
        for(int i=1;i<factorial.length;i++){
            sum = i*sum;
            factorial[i] = sum;
        }

        //create a list of index
        List<Integer> tmp = new ArrayList<>();
        for(int i=1;i<=n;i++){
            tmp.add(i);
        }
        //pattern
        k--;
        for(int i=1;i<=n;i++){
            int cur = k/factorial[n-i];
            str.append(tmp.get(cur));
            tmp.remove(cur);
            k -= cur*factorial[n-i];
        }
        return str.toString();
    }
}
