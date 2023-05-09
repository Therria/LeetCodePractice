public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            throw new IllegalArgumentException();
        }
        int n = gas.length;

        int start = n;
        int end = 0;
        int val = 0;
        while (end < start) { // [start, end)
            if (val >= 0) {
                val += gas[end] - cost[end];
                end++;
            } else {
                start--;
                val += gas[start] - cost[start];
            }
        }
        if (val < 0) {
            return -1;
        }
        return start % n;


    }

    public static void main(String[] args) {
        LC134 lc134 = new LC134();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc134.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc134.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        System.out.println();
    }
}
