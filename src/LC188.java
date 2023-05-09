public class LC188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            throw new IllegalArgumentException();
        }
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int len = Math.min(k, n / 2);
        int[][] buy = new int[len + 1][n];
        int[][] sell = new int[len + 1][n];
        for (int kk = 1; kk <= len; kk++) {
            buy[kk][0] = -prices[0];
            // sell[kk][0] = 0;
        }
        for (int kk = 1; kk <= len; kk++) {
            for (int i = 1; i < n; i++) {
                buy[kk][i] = Math.max(buy[kk][i - 1], sell[kk - 1][i - 1] - prices[i]);
                sell[kk][i] = Math.max(sell[kk][i - 1], buy[kk][i - 1] + prices[i]);
            }
        }
        return sell[len][n - 1];
    }

    public static void main(String[] args) {
        LC188 lc188 = new LC188();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc188.maxProfit(2, new int[]{2,4,1}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc188.maxProfit(2, new int[]{3,2,6,5,0,3}));
        System.out.println();
    }
}
