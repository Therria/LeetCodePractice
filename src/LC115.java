public class LC115 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (s.length() < t.length()) {
            return 0;
        }
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = s.charAt(i - 1);

                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {
        LC115 lc115 = new LC115();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc115.numDistinct("rabbbit", "rabbit"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc115.numDistinct("babgbag", "bag"));
        System.out.println();
    }
}
