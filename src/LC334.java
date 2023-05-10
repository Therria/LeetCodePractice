public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        // int n = nums.length;
        // if (n < 3) {
        //     return false;
        // }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int third: nums) {
            if (third > second) {
                return true;
            } else if (third <= first) {
                first = third;
            } else {
                second = third;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC334 lc334 = new LC334();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc334.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc334.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc334.increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc334.increasingTriplet(new int[]{1,2}));
        System.out.println();
    }
}
