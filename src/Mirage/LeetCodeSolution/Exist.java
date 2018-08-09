package Mirage.LeetCodeSolution;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The same letter cell may not be used more than once.
 * Note: Word can only be constructed from "adjacent" cell, which are those horizontally or vertically neighboring.
 * Example:
 * board =
 * {
 * {'A', 'B', 'C', 'E'},
 * {'S', 'F', 'C', 'S'},
 * {'A', 'D', 'E', 'E'}
 * }
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * @author BorisMirage
 * Time: 2018/08/09 15:26
 * Created with IntelliJ IDEA
 */

public class Exist {
    /**
     * Start from first char in word, then find adjacent cell until current cell is unavailable or all char was found.
     * Kindly similar to maze path finding method.
     *
     * @param board input 2D char board
     * @param word  input word string
     * @return true if found word in board, false otherwise.
     */
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (tracking(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Backtracking method.
     * Similar to find maze path, entry is the word's first char that found in board, exit is the last char (if exist).
     * Hence, recursively traverse each possible cell in board, if found available cell then continue searching.
     * In the end, if traverse to the end of string, return true, otherwise return false.
     *
     * @param board input 2D char board
     * @param word  input word string
     * @param i     current cell row
     * @param j     current cell column
     * @param m     current char index
     * @return true if word is found, false otherwise
     */
    private boolean tracking(char[][] board, String word, int i, int j, int m) {

        /* Check coord availability */
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(m)) {
            return false;
        }

        /* Exit point */
        if (m == word.length() - 1 && board[i][j] == word.charAt(m)) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = 0;

        boolean exist = tracking(board, word, i + 1, j, m + 1)
                || tracking(board, word, i, j + 1, m + 1)
                || tracking(board, word, i - 1, j, m + 1)
                || tracking(board, word, i, j - 1, m + 1);

        /* Recover temp char if word is not found for later searching */
        board[i][j] = temp;

        return exist;
    }
}
