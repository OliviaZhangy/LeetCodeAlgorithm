package src.Olivia;

//NO 187
//bit manipulation

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//hashmap and bit manipulation
public class findRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        //need a set to avoid duplicate
       Set<String> repeat = new HashSet<>();
        for(int i=0;i+9<s.length();i++){
            String ten = s.substring(i,i +10);
            if(!seen.add(ten)){
                repeat.add(ten);
            }
        }
        return new ArrayList<>(repeat);
    }
}
