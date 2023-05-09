public class LC309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException();
        }

        int n = prices.length;
        if (n == 1) {
            return 0;
        }

        int preBuy = -prices[0];
        int preSell1 = 0;
        int preSell2 = 0;
        for (int i = 1; i < n; i++) {
            int buy = Math.max(preBuy, preSell2 - prices[i]);
            int sell = Math.max(preSell1, preBuy + prices[i]);
            preBuy = buy;
            preSell2 = preSell1;
            preSell1 = sell;
        }
        return preSell1;
    }

    public static void main(String[] args) {
        LC309 lc309 = new LC309();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc309.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc309.maxProfit(new int[]{1}));
        System.out.println();
    }
}
