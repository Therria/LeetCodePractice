import java.util.*;

public class LC210 {
    private int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // corner case
        if (numCourses < 1 || prerequisites == null) {
            throw new IllegalArgumentException();
        }
        if (prerequisites.length == 0) {
            return noPre(numCourses);
        }
        if (prerequisites[0] == null || prerequisites[0].length != 2) {
            throw new IllegalArgumentException();
        }
        idx = numCourses - 1;
        int[] res = new int[numCourses];
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        Boolean[] visited = new Boolean[numCourses]; // null - initial, true - visiting, false - visited
        List<Integer> path = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited, res)) {
                return new int[]{};
            }
        }

        return res;
    }

    private boolean hasCycle(List<List<Integer>> graph, Integer cur, Boolean[] visited, int[] res) {
        Boolean status = visited[cur]; // null - initial, true - visiting, false - visited
        if (status != null) {
            return status;
        }
        visited[cur] = true;
        List<Integer> nexts = graph.get(cur);
        for (Integer next: nexts) {
            if (hasCycle(graph, next, visited, res)) {
                return true;
            }
        }
        visited[cur] = false;
        res[idx--] = cur;
        return false;
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int from = edge[1];
            int to = edge[0];
            graph.get(from).add(to);
        }
        return graph;
    }

    private int[] noPre(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        LC210 lc210 = new LC210();

        // Test case 1
        System.out.println("Test Case 1");
        System.out.println(Arrays.toString(lc210.findOrder(2, new int[][]{{1, 0}})));
        System.out.println();

        // Test case 2
        System.out.println("Test Case 2");
        System.out.println(Arrays.toString(lc210.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println();

        // Test case 3
        System.out.println("Test Case 3");
        System.out.println(Arrays.toString(lc210.findOrder(1, new int[][]{})));
        System.out.println();
    }
}
