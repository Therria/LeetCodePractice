import java.util.Arrays;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
//        if (right >= 0 && nums[right] == target) {
//            return right;
//        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
//        if (left < nums.length && nums[left] == target) {
//            return left;
//        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC34 lc34 = new LC34();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(Arrays.toString(lc34.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(Arrays.toString(lc34.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(Arrays.toString(lc34.searchRange(new int[]{}, 0)));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(Arrays.toString(lc34.searchRange(new int[]{1}, 0)));
        System.out.println();
    }
}
