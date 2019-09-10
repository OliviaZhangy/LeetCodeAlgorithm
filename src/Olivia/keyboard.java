package src.Olivia;

public class keyboard {
        public static int helper(String keyboard, String text) {
            int result = 0;
            int[] map = new int[26];
            // Range [a-z] -> Fill each with their distance (i)
            for(int i=0; i<keyboard.length(); i++)
                map[keyboard.charAt(i) - 'a'] = i;
            int j=0, prev = 0;
            // Add first character distance (no difference for first char)
            prev = map[text.charAt(j++) - 'a'];
            result += prev;
            // COmpute difference for each character to previous character
            while(j < text.length()) {
                int current = map[keyboard.charAt(j++) - 'a'];
                result += Math.abs(current - prev);
                prev = current;
            }
            return result;
        }
    }
}
