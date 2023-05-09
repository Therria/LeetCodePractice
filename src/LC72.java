public class LC72 {
    public int minDistance(String word1, String word2) {
        // corner case
        if(word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }
        if(word1.equals(word2)) {
            return 0;
        }
        int len1 = word1.length(), len2 = word2.length();
//        if (len1 == 0 || len2 == 0) {
//            return len1 == 0? len2 : len1;
//        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        // initialization
        for (int i  = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LC72 lc72 = new LC72();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc72.minDistance("horse", "ros"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc72.minDistance("intention", "execution"));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc72.minDistance("", "a"));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc72.minDistance("distance", "springbok"));
        System.out.println();
    }
}
