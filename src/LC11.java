public class LC11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            int l = height[start];
            int r = height[end];
            max = Math.max(max, Math.min(l, r) * (end - start));
            if (l <= r) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC11 lc11 = new LC11();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc11.maxArea(new int[]{1,1}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc11.maxArea(new int[]{0,0,0}));
        System.out.println();
    }
}
