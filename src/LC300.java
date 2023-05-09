import java.util.ArrayList;
import java.util.List;

public class LC300 {
    // Method I: DP
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            throw new IllegalArgumentException();
//        }
//        int n = nums.length;
//        if (n == 1) {
//            return 1;
//        }
//        int[] dp = new int[n];
//        dp[0] = 1;
//        int max = 1;
//        for (int i = 1; i < n; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    // Method II: Greedy
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int idx = smallestLargerOrEqual(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }

    private int smallestLargerOrEqual(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LC300 lc300 = new LC300();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc300.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc300.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println();
    }

}
