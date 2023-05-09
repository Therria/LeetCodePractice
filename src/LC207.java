import java.util.*;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if (numCourses < 1 || prerequisites == null) {
            throw new IllegalArgumentException();
        }
        if (prerequisites.length == 0) {
            return true;
        }
        if (prerequisites[0] == null || prerequisites[0].length != 2) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        Boolean[] visited = new Boolean[numCourses]; // null - initial, true - visiting, false - visited
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, Integer cur, Boolean[] visited) {
        Boolean status = visited[cur]; // null - initial, true - visiting, false - visited
        if (status != null) {
            return status;
        }
        visited[cur] = true;
        for (Integer next: graph.get(cur)) {
            if (hasCycle(graph, next, visited)) {
                return true;
            }
        }
        visited[cur] = false;
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

    public static void main(String[] args) {
        LC207 lc207 = new LC207();

        // Test case 1
        System.out.println("Test Case 1");
        System.out.println(lc207.canFinish(2, new int[][]{{1, 0}}));
        System.out.println();

        // Test case 2
        System.out.println("Test Case 2");
        System.out.println(lc207.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println();


    }

}
