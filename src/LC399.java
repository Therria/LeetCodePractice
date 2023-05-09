import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC399 {
    public class V {
        public String name;
        public V parent;
        public int size;
        public double val;

        public V(String name) {
            this.name = name;
            this.parent = this;
            this.size = 1;
            this.val = 1.0;
        }
    }

    public class UnionFind {
        HashMap<String, V> map;

        public UnionFind() {
            map = new HashMap<>();
        }

        public V root(V p) {
            V cur = p;
            double quotient = 1.0;
            while (cur.parent != cur) {
                cur.val *= cur.parent.val;
                quotient *= cur.val;
                cur.parent = cur.parent.parent;
                cur = cur.parent;
            }
            p.val = quotient;
            p.parent = cur;
            return cur;
        }

        public boolean find(V p, V q) {
            return root(p) == root(q);
        }

        public void union(V p, V q, double val) {
            V pRoot = root(p);
            V qRoot = root(q);
            if (pRoot.size >= qRoot.size) {// q add to p
                qRoot.parent = pRoot;
                qRoot.val = p.val * val / q.val;
                pRoot.size += q.size;
            } else {
                pRoot.parent = qRoot;
                pRoot.val = q.val / (p.val * val);
                qRoot.size += pRoot.size;
            }
        }

        public V addV(String name) {
            V v = map.get(name);
            if (v == null) {
                v = new V(name);
                map.put(name, v);
            }
            return v;
        }

        public V getV(String name) {
            return map.get(name);
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations == null || values == null || equations.size() != values.length || queries == null) {
            throw new IllegalArgumentException();
        }
        if (queries.size() == 0) {
            return new double[]{};
        }

        UnionFind uf = new UnionFind();
        int len = equations.size();
        for (int i = 0; i < len; i++) {
            V p = uf.addV(equations.get(i).get(0));
            V q = uf.addV(equations.get(i).get(1));
            if (!uf.find(p, q)) {
                uf.union(p, q, values[i]);
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            V p = uf.getV(queries.get(i).get(0));
            V q = uf.getV(queries.get(i).get(1));
            if (p == null || q == null) {
                res[i] = -1.0;
                continue;
            }
            if (uf.find(p, q)) {
                res[i] = q.val / p.val;
            } else {
                res[i] = -1.0;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        LC399 lc399 = new LC399();
        List<List<String>> equations = null;
        double[] values = null;
        List<List<String>> queries = null;


        // Test Case 1
        System.out.println("Test Case 1");
        equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        values = new double[]{2.0, 3.0};
        queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(lc399.calcEquation(equations, values, queries)));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("bc", "cd"));
        values = new double[]{1.5, 2.5, 5.0};
        queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("bc", "cd"));
        queries.add(Arrays.asList("cd", "bc"));
        System.out.println(Arrays.toString(lc399.calcEquation(equations, values, queries)));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        values = new double[]{0.5};
        queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("x", "y"));
        System.out.println(Arrays.toString(lc399.calcEquation(equations, values, queries)));
        System.out.println();
    }
}
