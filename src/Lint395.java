import java.util.List;

public class Lint395 {
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }

        int n = values.length;
        if (n <= 2) {
            return true;
        }

        int[] dp = new int[n + 2];
//        dp[n + 1] = 0;
//        dp[n] = 0;
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 1] + values[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            int one = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            int two = values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]);
            dp[i] = Math.max(one, two);
        }
        return dp[0] > dp[1] || dp[0] > dp[2];
    }

    public static void main(String[] args) {
        Lint395 lint395 = new Lint395();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lint395.firstWillWin(new int[]{1,2,2}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lint395.firstWillWin(new int[]{1, 2, 4}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lint395.firstWillWin(new int[]{1, 2, 3, 100, 5, 6, 7}));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lint395.firstWillWin(new int[]{2, 3, 100, 5, 6, 7}));
        System.out.println();
    }

}
