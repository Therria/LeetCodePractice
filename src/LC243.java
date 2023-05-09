public class LC243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length < 2) {
            throw new IllegalArgumentException();
        }
        int i1 = -1;
        int i2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                i1 = i;
            } else if (wordsDict[i].equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC243 lc243 = new LC243();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
        System.out.println();
    }
}
