package src.Olivia;

//NO 1104

import java.util.ArrayList;
import java.util.List;

public class pathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int)Math.ceil(Math.log(label)/Math.log(2));
        //look at the corner case, 16 should be at level 5
        if(label==(int)Math.pow(2,level)) level ++;

        List<Integer> res = new ArrayList<>();
        while(label>1){
            res.add(0,label);
            int low = (int)Math.pow(2,(level-1));
            int high = (int)Math.pow(2,level)-1;
            int pos;
            if(level%2==1){
                pos = label-low;
            }
            else{
                pos = high-label;
            }
            level--;
            label = search(pos/2,level);
        }
        res.add(0,1);
        return res;
    }
    private int search(int pos,int level){
        int label;
        if(level==1) return 1;
        if(level%2==1){
            label = (int)Math.pow(2,(level-1))+pos;
        }
        else{
            label = (int)Math.pow(2,level)-1-pos;
        }
        return label;
    }
}
