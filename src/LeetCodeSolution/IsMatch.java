package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/7/18
 * Time: 19:41
 */

public class IsMatch {

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * '.' Matches ANY single character.
     * '*' Matches zero or more of the PRECEDING element. (Which means "*" will not be first element of string)
     * The matching should cover the entire input string (not partial).
     *
     * @param s input String
     * @param p input Pattern
     * @return true if found match, false if not
     */
    public boolean isMatch(String s, String p) {

        /* Special case */
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            if (s.length() != 1) {
                return false;
            }
            return (s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.');
        }

        if (s.length() != 0 && (p.charAt(0) == s.charAt(0) || (p.charAt(0) == '.'))) {
            if (p.charAt(1) == '*') {
                return isMatch_2(s.substring(1), p) || isMatch_2(s, p.substring(2));
            }
            return isMatch_2(s.substring(1), p.substring(1));
        }
        return p.charAt(1) == '*' && isMatch_2(s, p.substring(2));
    }

    public boolean isMatch_2(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 2; i <= pLen; ++i) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                char ch1 = s.charAt(i - 1), ch2 = p.charAt(j - 1);
                if (ch2 != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (ch1 == ch2 || ch2 == '.');
                }
                else {
                    dp[i][j] = dp[i][j - 2];
                    if (ch1 == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                }
            }
        }
        return dp[sLen][pLen];
    }
}
