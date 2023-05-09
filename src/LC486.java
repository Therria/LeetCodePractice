public class LC486 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    int l = nums[i] + (preSum[j] - preSum[i]) - dp[i + 1][j];
                    int r = nums[j] + (preSum[j - 1] - (i - 1 >= 0? preSum[i - 1] : 0)) - dp[i][j - 1];
                    dp[i][j] = Math.max(l, r);
                }
            }
        }

        return dp[0][n - 1] >= (preSum[n - 1] - dp[0][n - 1]);
    }

    public static void main(String[] args) {
        LC486 lc486 = new LC486();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc486.PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc486.PredictTheWinner(new int[]{1,5,233,7}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc486.PredictTheWinner(new int[]{1,2,233,7,8,9}));
        System.out.println();
    }
}
