public class LC121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = prices.length;
        if (n == 1) {
            return 0;
        }

        int max = prices[n - 1];
        int res = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (max > prices[i]) {
                res = Math.max(res, max - prices[i]);
            } else {
                max = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC121 lc121 = new LC121();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc121.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc121.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println();
    }
}
