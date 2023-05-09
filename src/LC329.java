public class LC329 {
    private final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int n;
    private int m;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        n = matrix.length;
        m = matrix[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(matrix, Integer.MIN_VALUE, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int pre, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || pre >= matrix[i][j]) {
            return 0;
        }
        int max = 0;
        for (int[] dir: DIRS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            max = Math.max(max, dfs(matrix, matrix[i][j], ii, jj));
        }
        return max + 1;
    }

    public static void main(String[] args) {
        LC329 lc329 = new LC329();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc329.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        System.out.println();

        // Test Case 1
        System.out.println("Test Case 2");
        System.out.println(lc329.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        System.out.println();
    }
}
