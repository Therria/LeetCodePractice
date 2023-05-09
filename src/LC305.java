import java.util.LinkedList;
import java.util.List;

public class LC305 {
//    // Method 1: DFS X
//    public List<Integer> numIslands2(int m, int n, int[][] positions) {
//        if (m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length != 2) {
//            throw new IllegalArgumentException();
//        }
//        int[][] grid = new int[m][n];
//        List<Integer> res = new LinkedList<>();
//        for (int[] pos: positions) {
//            grid[pos[0]][pos[1]] = 1;
//            res.add(numIslands(grid));
//        }
//        return res;
//    }
//
//    private int numIslands(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
//            throw new IllegalArgumentException();
//        }
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1 && !visited[i][j]) {
//                    dfs(grid, i, j, visited);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
//            return;
//        }
//
//        visited[i][j] = true;
//        dfs(grid, i - 1, j, visited);
//        dfs(grid, i, j + 1, visited);
//        dfs(grid, i + 1, j, visited);
//        dfs(grid, i, j - 1, visited);
//    }

    public class UnionFind {
        private int[] parent;
        private int[] size;
        private int numOfIsland;

        public UnionFind(int m, int n) {
            this.parent = new int[m * n];
            this.size = new int[m * n];
            this.numOfIsland = 0;
        }

        private int root(int p) {
            int cur = p;
            while(parent[cur] != cur) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[p] = cur;
            return cur;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int pRoot = root(p);
            int qRoot = root(q);
            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
            numOfIsland--;
        }

        public void addIsland(int p) {
            parent[p] = p;
            size[p] = 1;
            numOfIsland++;
        }

        public boolean isIsland(int p) {
            return size[p] > 0;
        }

        public int getNumOfIsland() {
            return numOfIsland;
        }
    }
    private final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length != 2) {
            throw new IllegalArgumentException();
        }
        List<Integer> res = new LinkedList<>();
        UnionFind uf = new UnionFind(m, n);
        for (int[] pos: positions) {
            int i = pos[0], j = pos[1];
            int p = i * n + j;
            if (uf.isIsland(p)) {
                res.add(uf.getNumOfIsland());
                continue;
            }

            uf.addIsland(p);
            for (int[] dir: DIRS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                int q = ii * n + jj;
                if (ii < 0 || ii >= m || jj < 0 || jj >= n || !uf.isIsland(q)) {
                    continue;
                }
                if (!uf.find(p, q)) { // not in the same set
                    uf.union(p, q);
                }
            }
            res.add(uf.getNumOfIsland());
        }
        return res;
    }

    public static void main(String[] args) {
        LC305 lc305 = new LC305();

        // Test Case 1
        System.out.println("Test case 1");
        System.out.println(lc305.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}).toString());
        System.out.println();

        // Test Case 2
        System.out.println("Test case 2");
        System.out.println(lc305.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 1}}).toString());
        System.out.println();

        // Test Case 3
        System.out.println("Test case 3");
        System.out.println(lc305.numIslands2(1, 1, new int[][]{{0, 0}}).toString());
        System.out.println();

        // Test Case 4
        System.out.println("Test case 4");
        System.out.println(lc305.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 2}}).toString());
        System.out.println();
    }

}
