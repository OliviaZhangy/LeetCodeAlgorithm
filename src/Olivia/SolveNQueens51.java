package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] cur = new char[n][n];
        //fill can only fill one-dimensional
        for (int i = 0; i < n; i++) {
            Arrays.fill(cur[i], '.');
        }
        nQueensHelper(n, cur, result, 0);
        return result;
    }

    /* helper function
     *  using recursive to fill queen */
    private void nQueensHelper(int n, char[][] cur, List<List<String>> result, int quantity) {
        if (quantity == n) {
            result.add(transform(cur));
        }
        for (int i = 0; i < n; i++) {
            /* to check this place is validate or not */
            if (validate(cur, i, quantity)) {
                cur[i][quantity] = 'Q';
                nQueensHelper(n, cur, result, quantity + 1);
                cur[i][quantity] = '.';
            }
        }
    }

    /* validation function
     *  to validate whether this char[][] is validate or not
     *  return boolean */
    private boolean validate(char[][] cur, int x, int quantity) {
        for (int i = 0; i < cur.length; i++) {
            for (int j = 0; j < quantity; j++) {

                //check up and diagonal
                if (cur[i][j] == 'Q' && (x == i || Math.abs(x - i) == Math.abs(quantity - j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* transform function
     *  to transform char[][] to List<String>
     *      return List<String> */
    private List<String> transform(char[][] cur) {
        List<String> result = new ArrayList<>();
        for (char[] aCur : cur) {
            String tmp = new String(aCur);
            result.add(tmp);
        }
        return result;
    }
}
