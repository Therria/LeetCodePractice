import java.util.Arrays;

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                return new int[] {start + 1, end + 1};
            }
        }

        throw new RuntimeException("Invalid Input");
    }

    public static void main(String[] args) {
        LC167 lc167 = new LC167();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(Arrays.toString(lc167.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(Arrays.toString(lc167.twoSum(new int[]{2,3,4}, 6)));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(Arrays.toString(lc167.twoSum(new int[]{-1,0}, -1)));
        System.out.println();
    }
}
