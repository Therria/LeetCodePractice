public class LC69 {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        LC69 lc69 = new LC69();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc69.mySqrt(4));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc69.mySqrt(8));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc69.mySqrt(0));
        System.out.println();


        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc69.mySqrt(2147395599));
        System.out.println();
    }
}
