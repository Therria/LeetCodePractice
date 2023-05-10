public class LC302 {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            throw new IllegalArgumentException();
        }
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != '1') {
            throw new IllegalArgumentException();
        }

        int l = leftBound(image, y);
        int r = rightBound(image, y);
        int u = upBound(image, x);
        int d = downBound(image, x);
        return (r - l + 1) * (d - u + 1);
    }

    private int leftBound(char[][] image, int y) {
        int left = 0;
        int right = y - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (colHasOne(image, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int rightBound(char[][] image, int y) {
        int left = y + 1;
        int right = image[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (colHasOne(image, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int upBound(char[][] image, int x) {
        int up = 0;
        int down = x - 1;
        while(up <= down) {
            int mid = up + (down - up) / 2;
            if (rowHasOne(image, mid)) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }
        return up;
    }

    private int downBound(char[][] image, int x) {
        int up = x + 1;
        int down = image.length - 1;
        while(up <= down) {
            int mid = up + (down - up) / 2;
            if (rowHasOne(image, mid)) {
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }
        return down;
    }

    private boolean colHasOne(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean rowHasOne(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC302 lc302 = new LC302();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc302.minArea(new char[][]{{'0','0','1','0'}, {'0','1','1','0'}, {'0','1','0','0'}}, 0, 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc302.minArea(new char[][]{{'1'}}, 0, 0));
        System.out.println();
    }
}
