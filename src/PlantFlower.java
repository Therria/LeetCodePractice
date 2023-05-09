public class PlantFlower {
    /*
    Given int[] array with 0 and 1, 1 means there is a flower while 0 means empty, you can plant at most two flowers continuously,
    return how many flowers you can plant at most
    */

    public int plantFlower(int[] flowers) {
        if (flowers == null || flowers.length == 0) {
            throw new IllegalArgumentException();
        }
        int res = 0;
        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] == 0 && canPlant(flowers, i)) {
                flowers[i] = 1;
                res++;
            }
        }
        return  res;
    }

    private boolean canPlant(int[] arr, int i) {
        int pre2 = i - 2 >= 0 ? arr[i - 2] : 0;
        int pre1 = i - 1 >= 0 ? arr[i - 1] : 0;
        int nxt1 = i + 1 < arr.length ? arr[i + 1] : 0;
        int nxt2 = i + 2 < arr.length ? arr[i + 2] : 0;
        if (pre1 * pre2 == 0 && pre1 * nxt1 == 0 && nxt1 * nxt2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PlantFlower pf = new PlantFlower();

        // Test Case 1
        System.out.println("Test case 1");
        System.out.println(pf.plantFlower(new int[]{0, 0, 0}));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(pf.plantFlower(new int[]{0, 1, 0, 1, 0, 0, 1, 1}));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(pf.plantFlower(new int[]{1, 1, 0, 1, 0, 0, 1, 1}));
        System.out.println();

        // Test Case 4
        System.out.println("Test case 4");
        System.out.println(pf.plantFlower(new int[]{1, 0, 0, 0, 1}));
        System.out.println();

        // Test Case 5
        System.out.println("Test case 5");
        System.out.println(pf.plantFlower(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println();

        // Test Case 6
        System.out.println("Test case 6");
        System.out.println(pf.plantFlower(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 1}));
        System.out.println();
    }
}