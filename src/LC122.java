public class LC122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException();
        }

        int n = prices.length;
        if (n == 1) {
            return 0;
        }

        int preBuy = -prices[0];
        int preSell = 0;
        for (int i = 1; i < n; i++) {
            int buy = Math.max(preBuy, preSell - prices[i]);
            int sell = Math.max(preSell, preBuy + prices[i]);
            preBuy = buy;
            preSell = sell;
        }
        return preSell;
    }

    public static void main(String[] args) {
        LC122 lc122 = new LC122();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc122.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc122.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc122.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println();
    }
}
