package Mirage.LeetCodeSolution;


/**
 * @author BorisMirage
 * Time: 6/22/18 13:01
 * Created with IntelliJ IDEA
 */

public class SolveSudoku {
    /**
     * Solve a Sudoku puzzle by filling the empty cells.
     * A sudoku solution must satisfy all of the following rules:
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * Empty cells are indicated by the character '.'.
     * <p>
     * Note:
     * The given board contain only digits 1-9 and the character '.'.
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * The given board size is always 9x9.
     * <p>
     * Use recursion with IsValidSudoku.
     *
     * @param board input Sudoku board
     */
    public void solveSudoku(char[][] board) {
        tryFilling(board);
    }

    /**
     * Use backtracking to find correct char to fill in blank
     *
     * @param board Sudoku board
     * @return if this board is valid
     */
    private boolean tryFilling(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    /* Try every possible char to fill current blank */
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (tryFilling(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    /* If each char is invalid, return false */
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check whether current input is valid.
     *
     * @param b Sudoku board
     * @param s column coord
     * @param r row coord
     * @return true if valid, false otherwise
     */
    private boolean isValidSudoku(char[][] b, int r, int c, char s) {

        for (int i = 0; i < 9; i++) {
            if (b[i][c] != '.' && b[i][c] == s) {
                return false;
            }
            if (b[r][i] != '.' && b[r][i] == s) {
                return false;
            }
            if (b[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] != '.' &&
                    b[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == s) {
                return false;
            }
        }
        return true;
    }
}
