public class LC714 {
    public int maxProfit(int[] prices, int fee) {
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
            int sell = Math.max(preSell, preBuy + prices[i] - fee);
            preBuy = buy;
            preSell = sell;
        }
        return preSell;
    }

    public static void main(String[] args) {
        LC714 lc714 = new LC714();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc714.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc714.maxProfit(new int[]{1,3,7,5,10,3}, 3));
        System.out.println();
    }
}
