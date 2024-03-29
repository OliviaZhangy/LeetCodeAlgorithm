package Mirage.LeetCodeSolution;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * @author BorisMirage
 * Time: 2019/01/31 21:54
 * Created with IntelliJ IDEA
 */

public class MaxProfit_188 {
    /**
     * Dynamic programming with table.
     * [i, j] = max([i, j - 1], prices[j] - prices[j'] + [i - 1, j'])
     * i: ith transaction
     * j: prices[j], index in int array price
     * j': in range of [0, j-1]
     * => [i, j] = max([i, j - 1], prices[j] + max([i - 1, j'] - prices[j']))  (efficient for looping)
     * dp[0, j] = 0
     * dp[i, 0] = 0
     *
     * @param k      at most k transactions
     * @param prices int array
     * @return max profit
     */
    public int maxProfit(int k, int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        /* Special case: compare between current and previous value in array */
        if (k >= prices.length / 2) {       // k is sufficient for comparing each adjacent value in array
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[] r1 = new int[prices.length];
        int[] r2 = new int[prices.length];

        for (int i = 0; i < k + 1; i++) {
            int base = -prices[0];
            for (int j = 0; j < r1.length; j++) {
                r2[j] = Integer.max(r2[j - 1], prices[j] + base);
                base = Integer.max(base, r1[j] - prices[j]);

            }

            /* Reduce memory usage */
            for (int j = 0; j < prices.length; j++) {
                r1[j] = r2[j];
                r2[j] = 0;
            }
        }

        return r2[prices.length - 1];
    }
}
