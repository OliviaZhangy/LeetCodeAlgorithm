package src.Olivia;

//NO 17
//Try using BFS
import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        //corner case
        if (digits.equals("")) {
            return result;
        }
        //initial a table to get
        char[][] table = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        String str = "";
        letterHelper(table, result, digits, str);
        return result;

    }

    // a helper function to get the list
    private void letterHelper(char[][] table, List<String> result, String digits, String str) {
        int len = digits.length();
        int str_len = str.length();
        if (str_len == len) {
            result.add(str);
            return;
        }
        char cur = digits.charAt(str_len);
        //Very important!! should be '2' not 2
        int size = table[cur - '2'].length;
        for (int i = 0; i < size; i++) {
            String tmp = str;
            str = str + table[cur - '2'][i];
            letterHelper(table, result, digits, str);
            str = tmp;
        }
    }
}
