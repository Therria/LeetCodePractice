import java.util.Arrays;

public class LC259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int t = target - nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                if (nums[start] + nums[end] >= t) {
                    end--;
                } else {
                    count += end - start;
                    start++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC259 lc259 = new LC259();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc259.threeSumSmaller(new int[]{-2,0,1,3}, 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc259.threeSumSmaller(new int[]{}, 0));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc259.threeSumSmaller(new int[]{0}, 0));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc259.threeSumSmaller(new int[]{3,1,0,-2}, 4));
        System.out.println();
    }
}
