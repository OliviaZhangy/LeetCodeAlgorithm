package src.Olivia;

import java.util.ArrayList;
import java.util.List;

//NO 271
//others

public class Codec {


    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            //add length and / before the world
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            //use the length to find the next word
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            result.add(s.substring(slash + 1, i));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));