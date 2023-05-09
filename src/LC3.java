import java.util.HashMap;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            Integer idx = map.get(cur);
            if (idx != null) { // repeat
                start = Math.max(start, idx + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(cur, end);
        }
        return max;
    }

    public static void main(String[] args) {
        LC3 lc3 = new LC3();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc3.lengthOfLongestSubstring("bbbbb"));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc3.lengthOfLongestSubstring("pwwkew"));
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4");
        System.out.println(lc3.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println();

    }
}
