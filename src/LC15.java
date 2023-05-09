import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = n - 1;
            int t = -nums[i];
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum < t) {
                    start++;
                } else if (sum > t) {
                    end--;
                } else { // sum == t
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start++], nums[end--])));
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC15 lc15 = new LC15();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc15.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc15.threeSum(new int[]{0,1,1}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc15.threeSum(new int[]{0,0,0}));
        System.out.println();
    }

}
