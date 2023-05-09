import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    // Method I
//    // DP: dp[i] -> [i, len)
//    public boolean wordBreak(String s, List<String> wordDict) {
//        // corner case
//        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
//            throw new IllegalArgumentException();
//        }
//        Set<String> dict = new HashSet<>();
//        for (String word: wordDict) {
//            dict.add(word);
//        }
//        int len = s.length();
//        boolean[] dp = new boolean[len + 1];
//        dp[len] = true;
//        for (int i = len - 1; i >= 0 ; i--) {
//            for (int j = i + 1; j <= len; j++) {
//                if (dp[j] && dict.contains(s.substring(i, j))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[0];
//    }

    // Method II
//    // DP: dp[i] -> [0, i)
//    public boolean wordBreak(String s, List<String> wordDict) {
//        // corner case
//        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
//            throw new IllegalArgumentException();
//        }
//
//        int len = s.length();
//        boolean[] dp = new boolean[len + 1];
//        HashSet<String> dic = new HashSet<>();
//        for (String word: wordDict) {
//            dic.add(word);
//        }
//        dp[0] = true;
//        for (int i = 1; i <= len; i++) {
//            for (int j = 1; j <= i; j++) {
//                if (dp[j - 1] && dic.contains(s.substring(j - 1, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[len];
//    }

    // Method III
    // DFS + Pruning
    public boolean wordBreak(String s, List<String> wordDict) {
        // corner case
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            throw new IllegalArgumentException();
        }
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        return dfs(s, dict, 0, new Boolean[s.length() + 1]);
    }

    private boolean dfs(String s, Set<String> dict, int idx, Boolean[] mem) {
        if (idx == s.length()) {
            return true;
        }


        if (mem[idx] != null) {
            return mem[idx];
        }

        for (int i = idx; i < s.length(); i++) {
            if (dict.contains(s.substring(idx, i + 1))) {
                if (dfs(s, dict, i + 1, mem)) {
                    mem[idx] = true;
                    return true;
                }
            }
        }
        mem[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        LC139 lc139 = new LC139();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc139.wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc139.wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc139.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        System.out.println();

        // Test Case 4
        System.out.println("Test case 4");
        System.out.println(lc139.wordBreak("aaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
        System.out.println();


    }
}
