import java.util.LinkedHashMap;
import java.util.Map;

public class LC340 {
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if (s == null || s.length() == 0) {
//            throw new IllegalArgumentException();
//        }
//        int n = s.length();
//        if (n <= k) {
//            return n;
//        }
//
//        int[] count = new int[256];
//        int cnt = 0;
//        int start = 0;
//        int max = 0;
//        for (int end = 0; end < n; end++) {
//            char cur = s.charAt(end);
//            count[cur]++;
//            if (count[cur] == 1) {
//                cnt++;
//            }
//            while (cnt > k) {
//                char ch = s.charAt(start++);
//                count[ch]--;
//                if (count[ch] == 0) {
//                    cnt--;
//                }
//            }
//            max = Math.max(max, end - start + 1);
//        }
//        return max;
//    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int n = s.length();
        if (n <= k) {
            return n;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            if (map.containsKey(cur)) {
                map.remove(cur);
            }
            map.put(cur, end);
            while (map.size() > k) {
                char leftMost = map.entrySet().iterator().next().getKey();
                start = map.get(leftMost) + 1;
                map.remove(leftMost);
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LC340 lc340 = new LC340();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc340.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc340.lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println();
    }
}
