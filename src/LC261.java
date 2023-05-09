import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC261 {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges == null) {
            throw new IllegalArgumentException();
        }
        int len = edges.length;
        if (n != len + 1) { // Tree: V = E + 1
            return false;
        }
        if (len == 0) {
            return true;
        }
        if (edges[0] == null || edges[0].length != 2) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> graph = buildGraph(n, edges);
        Boolean[] visited = new Boolean[n]; // initial - null; false - visited; true - visiting
        for (int i = 0; i < n; i++) {
            if (hasCycle(graph, visited, i, -1)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, Boolean[] visited, int cur, int parent) {
        if (visited[cur] != null) {
            return visited[cur];
        }
        visited[cur] = true;
        List<Integer> nexts = graph.get(cur);
        for (int next: nexts) {
            if (next == parent) {
                continue;
            }
            if (hasCycle(graph, visited, next, cur)) {
                return true;
            }
        }
        visited[cur] = false;
        return false;
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] edge: edges) {
            int p = edge[0], q = edge[1];
            graph.get(p).add(q);
            graph.get(q).add(p);
        }
        return graph;
    }

    public static void main(String[] args) {
        LC261 lc261 = new LC261();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc261.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc261.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc261.validTree(5, new int[][]{{0, 1}, {0, 4}, {2, 3}, {1, 4}}));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc261.validTree(1, new int[][]{}));
        System.out.println();

        // Test Case 5
        System.out.println("Test Case 5");
        System.out.println(lc261.validTree(4, new int[][]{{1,2}, {1, 3}, {2, 3}}));
        System.out.println();
    }
}
