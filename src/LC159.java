public class LC159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int n = s.length();
        if (n <= 2) {
            return n;
        }

        int max = 0;
        char c1 = ' ';
        char c2 = ' ';
        int idx1 = -1;
        int idx2 = -1;
        int start = 0;
        for (int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            if (c1 == cur) {
                idx1 = end;
            } else if (c2 == cur) {
                idx2 = end;
            } else {
                if (idx1 <= idx2) {
                    c1 = cur;
                    start = idx1 + 1;
                    idx1 = end;
                } else {
                    c2 = cur;
                    start = idx2 + 1;
                    idx2 = end;
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }



    public static void main(String[] args) {
        LC159 lc159 = new LC159();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc159.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc159.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println();
    }
}
