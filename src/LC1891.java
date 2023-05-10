public class LC1891 {
    public int maxLength(int[] ribbons, int k) {
        if (ribbons == null || ribbons.length == 0 || k <= 0) {
            throw new IllegalArgumentException();
        }

        int max = 0;
        long sum = 0;
        for (int l: ribbons) {
            sum += l;
            max = Math.max(max, l);
        }
        int left = 1;
        int right = Math.min((int)(sum / k), max);
        // int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCut(ribbons, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean canCut(int[] ribbons, int k, int len) {
        int count = 0;
        for (int l: ribbons) {
            count += l / len;
            if (count >= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC1891 lc1891 = new LC1891();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc1891.maxLength(new int[]{9,7,5}, 3));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc1891.maxLength(new int[]{7,5,9}, 4));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc1891.maxLength(new int[]{7,5,9}, 22));
        System.out.println();


    }
}
