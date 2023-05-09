import java.util.Arrays;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        LC35 lc35 = new LC35();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc35.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc35.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc35.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println();

    }
}
