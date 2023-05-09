public class LC278 {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int v) {
        throw new IllegalArgumentException();
    }

}
