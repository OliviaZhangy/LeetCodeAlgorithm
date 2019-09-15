package src.Olivia;

import java.util.HashMap;
import java.util.Map;

public class maxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if(!map.containsKey(c))
                map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        if(!map.containsKey('b')) return 0;
        else{
            res = map.get('b');
        }
        if(!map.containsKey('a')) return 0;
        else{
            res = Math.min(res,map.get('a'));
        }
        if(!map.containsKey('l')) return 0;
        if(!map.containsKey('o')) return 0;
        if(!map.containsKey('n')) return 0;
        res = Math.min(res,map.get('l')/2);
        res = Math.min(res,map.get('o')/2);
        res = Math.min(res,map.get('n'));
        return res;
    }
}
