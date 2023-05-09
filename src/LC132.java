public class LC132 {
//    public int minCut(String s) {
//        if (s == null || s.length() == 0) {
//            throw new IllegalArgumentException();
//        }
//        int len = s.length();
//        if (len == 1) {
//            return 0;
//        }
//
//        int[] dp = new int[len + 1];
//        dp[len] = 0;
//        for (int i = len - 1; i >= 0; i--) {
//            int min = Integer.MAX_VALUE;
//            for (int j = i; j < len ; j++) {
//                if (isPalindrome(s.substring(i, j + 1))) {
//                    min = Math.min(min, dp[j + 1]);
//                }
//            }
//            dp[i] = min + 1;
//        }
//        return dp[0] - 1;
//    }
//
//    private boolean isPalindrome(String s) {
//        int i = 0, j = s.length() - 1;
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int len = s.length();
        if (len == 1) {
            return 0;
        }

        int[] dp = new int[len + 1];
        dp[len] = 0;
        boolean[][] isPalin = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < len ; j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && ((j == i + 1) || isPalin[i + 1][j - 1]))) {
                    isPalin[i][j] = true;
                    min = Math.min(min, dp[j + 1]);
                }
            }
            dp[i] = min + 1;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        LC132 lc132 = new LC132();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc132.minCut("aab"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc132.minCut("a"));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc132.minCut("ab"));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc132.minCut("abcde"));
        System.out.println();
    }

}
