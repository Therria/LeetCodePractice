public class LC123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException();
        }

        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int len = Math.min(2, n / 2);

        int preBuy1 = -prices[0];
        int preBuy2 = -prices[0];
        int preSell1 = 0;
        int preSell2 = 0;

        for (int i = 1; i < n; i++) {
            int buy1 = Math.max(preBuy1, -prices[i]);
            int sell1 = Math.max(preSell1, preBuy1 + prices[i]);
            preBuy1 = buy1;
            preSell1 = sell1;

            int buy2 = Math.max(preBuy2, preSell1 - prices[i]);
            int sell2 = Math.max(preSell2, preBuy2 + prices[i]);
            preBuy2 = buy2;
            preSell2 = sell2;
        }

        return preSell2;
    }

    public static void main(String[] args) {
        LC123 lc123 = new LC123();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc123.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc123.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc123.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println();


    }
}
