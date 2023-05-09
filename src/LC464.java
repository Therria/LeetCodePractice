import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger < 1 || desiredTotal < 0) {
            throw new IllegalArgumentException();
        }
        if (desiredTotal == 0) {
            return true;
        }

        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        int pool = (1 << maxChoosableInteger) - 1;
        return dfs(pool, 0, maxChoosableInteger, desiredTotal, new HashMap<>());
    }

    private boolean dfs(int pool, int sum, int max, int total, Map<Integer, Boolean> mem) {
        if (sum >= total) {
            mem.put(pool, false);
            return false;
        }
        Boolean status = mem.get(pool);
        if (status != null) {
            return status;
        }

        for (int i = 0; i < max; i++) {
            int mask = 1 << i;
            if ((pool & mask) != 0) {
                pool -= mask;
                boolean res = dfs(pool, sum + i + 1, max, total, mem);
                pool += mask;
                if(!res) {
                    mem.put(pool, true);
                    return true;
                }
            }
        }
        mem.put(pool, false);
        return false;
    }

    public static void main(String[] args) {
        LC464 lc464 = new LC464();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc464.canIWin(10, 11));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc464.canIWin(20, 210));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc464.canIWin(5, 50));
        System.out.println();
    }
}
