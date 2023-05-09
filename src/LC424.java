public class LC424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0 ) {
            throw new IllegalArgumentException();
        }

        int n = s.length();
        int[] count = new int[26];
        int start = 0;
        int res = 0;
        char maxChar = '\0';
        for (int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            count[cur - 'A']++;
            if (maxChar == '\0' || count[cur - 'A'] > count[maxChar - 'A']) {
                maxChar = cur;
            }

            while (start < end && (end - start + 1 - count[maxChar - 'A']) > k) {
                count[s.charAt(start++) - 'A']--;
                // update maxChar if needed
                for (int i = 0; i < 26; i++) {
                    if (count[i] > count[maxChar - 'A']) {
                        maxChar = (char)('A' + i);
                    }
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LC424 lc424 = new LC424();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc424.characterReplacement("ABAB", 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc424.characterReplacement("AABABBA", 1));
        System.out.println();
    }
}
