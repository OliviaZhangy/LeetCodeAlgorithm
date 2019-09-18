package src.Olivia;
//NO 524

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class findLongestWord {
    public String findLongestWord(String s, List<String> d) {
        //sort the dictionary
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                else {
                    return o2.length() - o1.length();
                }
            }
        });

            //check each word in the dic can be converted by s
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }

}
