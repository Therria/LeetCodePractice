import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC269 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }

        List<Character>[] graph = buildGraph(words);
        if (graph == null) {
            return "";
        }
        int[] visited = new int[26];
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (graph[i] != null) {
                if (hasCycle(graph, (char)(i + 'a'), visited, path)) {
                    return "";
                }
            }
        }
        return path.reverse().toString();
    }

    private boolean hasCycle(List<Character>[] graph, char cur, int[] visited, StringBuilder path) {
        int idx = cur - 'a';
        if (visited[idx] > 0) {
            return visited[idx] == 1? true : false;
        }

        visited[idx] = 1;
        for (char next: graph[idx]) {
            if (hasCycle(graph, next, visited, path)) {
                return true;
            }
        }
        visited[idx] = 2;
        path.append(cur);
        return false;
    }

    private List<Character>[] buildGraph(String[] words) {
        List<Character>[] graph = new ArrayList[26];
        if (words.length == 1) {
            for (char ch: words[0].toCharArray()) {
                addToGraph(graph, ch);
            }
            return graph;
        }

        for (int k = 0; k < words.length - 1; k++) {
            String s1 = words[k];
            String s2 = words[k + 1];
            int len1 = s1.length(), len2 = s2.length();
            int i = 0, j = 0;
            boolean isDiff = false;
            while (i < len1 && j < len2) {
                char c1 = s1.charAt(i), c2 = s2.charAt(j);
                addToGraph(graph, c1);
                if (c1 == c2) {
                    i++;
                    j++;
                } else {
                    isDiff = true;
                    i++;
                    graph[c1 - 'a'].add(c2);
                    break;
                }
            }
            if (!isDiff && len1 > len2) {
                return null;
            }
            if (k == 0) {
                while (i < len1) {
                    addToGraph(graph, s1.charAt(i++));
                }
            }
            while (j < len2) {
                addToGraph(graph, s2.charAt(j++));
            }
        }
        return graph;
    }

    private void addToGraph(List<Character>[] graph, char c) {
        // check existence, if not -> add to graph
        int idx = c - 'a';
        List<Character> nexts = graph[idx];
        if (nexts == null) {
            graph[idx] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        LC269 lc269 = new LC269();

        // Test case 1
        System.out.println("Test Case 1");
        System.out.println(lc269.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
        System.out.println();

        // Test case 2
        System.out.println("Test Case 2");
        System.out.println(lc269.alienOrder(new String[]{"z","z"}));
        System.out.println();

        // Test case 3
        System.out.println("Test Case 3");
        System.out.println(lc269.alienOrder(new String[]{"z","x","z"}));
        System.out.println();

        // Test case 3
        System.out.println("Test Case 3");
        System.out.println(lc269.alienOrder(new String[]{"aba"}));
        System.out.println();
    }
}
