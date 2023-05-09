import java.util.Arrays;

public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }

        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int t = target - nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum > t) {
                    end--;
                } else if (sum < t) {
                    start++;
                } else { // sum == t
                    return target;
                }
                res = Math.abs(res - target) <= Math.abs(sum - t) ? res :  (sum + nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC16 lc16 = new LC16();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc16.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc16.threeSumClosest(new int[]{0,1,2}, 3));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc16.threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println();
    }
}
