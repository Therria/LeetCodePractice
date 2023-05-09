public class LC97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException();
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        if (len3 == 0) {
            return true;
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char target = s3.charAt(i + j - 1);
                dp[i][j] = (s1.charAt(i - 1) == target && dp[i - 1][j]) || (s2.charAt(j - 1) == target && dp[i][j - 1]);
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LC97 lc97 = new LC97();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc97.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc97.isInterleave("", "", ""));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc97.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println();
    }
}
