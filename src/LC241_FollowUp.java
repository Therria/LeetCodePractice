import java.util.Arrays;
import java.util.List;

/*
Given a List<Integer> input, output a maximum result by adding operations(+, -, *, /)

 */
public class LC241_FollowUp {
    public int computeMax(List<Integer> nums) {
        // corner case
        if (nums == null || nums.size() == 0) {
            throw new IllegalArgumentException();
        }

        return 0;
    }


    public static void main(String[] args) {
        LC241_FollowUp lc241_followUp = new LC241_FollowUp();

        // Test Case 1
        System.out.println("Test Case 1");
        int res1 = lc241_followUp.computeMax(Arrays.asList(1,2,3));
        System.out.println("Output: " + res1);
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        int res2 = lc241_followUp.computeMax(Arrays.asList(1,2,3,4));
        System.out.println("Output: " + res2);
        System.out.println();
    }
}
