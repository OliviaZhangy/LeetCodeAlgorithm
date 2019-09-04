package src.Olivia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//No 266

public class canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
    Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
        if (!set.contains(s.charAt(i)))
            set.add(s.charAt(i));
        else
            set.remove(s.charAt(i));
    }
        return set.size()==0 || set.size()==1;

    }
}
