import java.util.Arrays;
import java.util.HashMap;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new RuntimeException("Invalid Input");
    }

    public static void main(String[] args) {
        LC1 lc1 = new LC1();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(Arrays.toString(lc1.twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println();
    }
}
