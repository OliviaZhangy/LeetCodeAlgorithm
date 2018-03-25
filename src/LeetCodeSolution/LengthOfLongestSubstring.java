package LeetCodeSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.UnknownFormatConversionException;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/23/18
 * Time: 12:27
 */


class LengthOfLongestSubstring {
    /**
     * @param s input string
     * @return max sub-string length
     */
    public int lengthOfLongestSubstring(String s) {

        /* Init variables */
        int result = 0;
        int subStart = 0;

        /* Init new map */
        Map<Character, Integer> thisMap = new HashMap<>();

        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 0) {
            return 0;
        }

        /* Search every char in string */
        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (thisMap.containsKey(currentChar)) {
                subStart = Math.max(thisMap.get(currentChar), subStart);
            }
            result = Math.max(result, i - subStart + 1);
            thisMap.put(s.charAt(i), i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));
    }
}


