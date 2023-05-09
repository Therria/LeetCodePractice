public class LC33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target >= nums[left]) { // target in unrotated part
                if (target > nums[mid] && nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // target in rotated part
                if (target < nums[mid] && nums[mid] <= nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC33 lc33 = new LC33();


        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc33.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc33.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc33.search(new int[]{1}, 0));
        System.out.println();
    }
}
