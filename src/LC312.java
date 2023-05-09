public class LC312 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int left = i - 1 >= 0 ? nums[i - 1] : 1;
                int right = j + 1 < n ? nums[j + 1] : 1;
                if (i == j) { // base case : only one balloon
                    dp[i][i] = nums[i] * left * right;
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int leftPart = k == i ? 0 : dp[i][k - 1];
                    int rightPart = k == j ? 0 : dp[k + 1][j];
                    max = Math.max(max, leftPart + rightPart + nums[k] * left * right);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LC312 lc312 = new LC312();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc312.maxCoins(new int[]{3,1,5,8}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc312.maxCoins(new int[]{1,5}));
        System.out.println();
    }
}
