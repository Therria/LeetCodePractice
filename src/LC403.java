import java.util.HashMap;

public class LC403 {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 2 || stones[0] != 0) {
            throw new IllegalArgumentException();
        }
        if (stones[1] != 1) {
            return false;
        }
        return dfs(stones, 1, 1, new HashMap[stones.length]);
    }

    private boolean dfs(int[] stones, int idx, int k, HashMap<Integer, Boolean>[] mems) {
        if (idx >= stones.length) {
            return false;
        }
        if (idx == stones.length - 1) {
            return true;
        }
        HashMap<Integer, Boolean> mem = mems[idx];
        if (mem != null) {
            Boolean status = mem.get(k);
            if (status != null) {
                return status;
            }
        } else {
            mem = new HashMap<Integer, Boolean>();
            mems[idx] = mem;
        }

        int min = stones[idx] + k - 1;
        int max = stones[idx] + k + 1;
        for (int i = idx + 1; i < stones.length; i++) {
            if (stones[i] >= min && stones[i] <= max) {
                if (dfs(stones, i, stones[i] - stones[idx], mems)) {
                    mem.put(k, true);
                    return true;
                }
            }
            if (stones[i] > max) {
                break;
            }
        }
        mem.put(k, false);
        return false;
    }

    public static void main(String[] args) {
        LC403 lc403 = new LC403();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc403.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc403.canCross(new int[]{0,1,2,3,4,8,9,11}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc403.canCross(new int[]{0,2}));
        System.out.println();

    }

}
