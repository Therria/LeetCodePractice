import java.util.ArrayList;
import java.util.List;

// non-decreasing based on LC300
public class LC300_FollowUp_1 {
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
                int idx = smallestLarger(list, nums[i]);
                if (idx < list.size()) {
                    list.set(idx, nums[i]);
                } else {
                    list.add(nums[i]);
                }
            }
        }
        return list.size();
    }

    private int smallestLarger(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LC300_FollowUp_1 lc300_followUp_1 = new LC300_FollowUp_1();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc300_followUp_1.lengthOfLIS(new int[]{10,9,2,3,7,5,3,4,5,6}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc300_followUp_1.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc300_followUp_1.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println();
    }
}
