import java.util.*;

public class LC721 {
    class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int root(int p) {
            int cur = p;
            while (parent[cur] != cur) {
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
            int pRoot = root(p), qRoot = root(q);
            if (size[pRoot] >= size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            throw new IllegalArgumentException();
        }
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        HashMap<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = i;
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                Integer q = emailToId.get(email);
                if (q == null) {
                    emailToId.put(emails.get(j), i);
                    continue;
                }
                if (!uf.find(p, q)) {
                    uf.union(p, q);
                }
            }
        }

        HashMap<Integer, TreeSet<String>> idToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToId.entrySet()) {
            String email = entry.getKey();
            int idx = entry.getValue();
            int root = uf.root(idx);
            TreeSet<String> emailSet = idToEmails.getOrDefault(root, new TreeSet<>());
            emailSet.add(email);
            idToEmails.put(root, emailSet);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry: idToEmails.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(entry.getKey()).get(0));
            list.addAll(entry.getValue());
            res.add(list);
        }

        return res;

    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        if (accounts == null || accounts.size() == 0) {
//            throw new IllegalArgumentException();
//        }
//        int n = accounts.size();
//
//        List<List<Integer>> graph = buildGraph(accounts);
//        boolean[] visited = new boolean[n];
//        HashMap<Integer, TreeSet<String>> groupMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                TreeSet<String> emails = new TreeSet<>();
//                dfs(accounts, graph, i, visited, emails);
//                groupMap.put(i, emails);
//            }
//        }
//
//        List<List<String>> res = new ArrayList<>();
//        for (Map.Entry<Integer, TreeSet<String>> entry: groupMap.entrySet()) {
//            List<String> list = new ArrayList<>();
//            list.add(accounts.get(entry.getKey()).get(0));
//            list.addAll(entry.getValue());
//            res.add(list);
//        }
//
//        return res;
//
//    }
//
//    private void dfs(List<List<String>> accounts, List<List<Integer>> graph, int cur, boolean[] visited, TreeSet<String> emails) {
//        if (visited[cur]) {
//            return;
//        }
//
//        List<String> eList = accounts.get(cur);
//        for (int i = 1; i < eList.size(); i++) {
//            emails.add(eList.get(i));
//        }
//        visited[cur] = true;
//        for (int next: graph.get(cur)) {
//            dfs(accounts, graph, next, visited, emails);
//        }
//    }
//
//    private List<List<Integer>> buildGraph(List<List<String>> accounts) {
//        List<List<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i < accounts.size(); i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < accounts.size(); i++) {
//            List<String> emails = accounts.get(i);
//            for (int j = 1; j < emails.size(); j++) {
//                String email = emails.get(j);
//                Integer idx = map.get(email);
//                if (idx == null) {
//                    map.put(email, i);
//                } else {
//                    graph.get(i).add(idx);
//                    graph.get(idx).add(i);
//                }
//            }
//        }
//        return graph;
//    }

    public static void main(String[] args) {
        LC721 lc721 = new LC721();

        List<List<String>> accounts = null;

        // Test Case 1
        System.out.println("Test Case 1");
        accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(lc721.accountsMerge(accounts).toString());
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        accounts.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
        accounts.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
        accounts.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));
        System.out.println(lc721.accountsMerge(accounts).toString());
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        accounts = new ArrayList<>();
        accounts.add(Arrays.asList("1","a@","b@","c@"));
        accounts.add(Arrays.asList("1","b@","d@","e@"));
        accounts.add(Arrays.asList("2","f@","g@"));
        accounts.add(Arrays.asList("1","e@"));
        accounts.add(Arrays.asList("1","h@"));
        System.out.println(lc721.accountsMerge(accounts).toString());
        System.out.println();

    }
}
