import java.util.*;

public class LC140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            throw new IllegalArgumentException();
        }
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        List<String> res = new LinkedList<>();
        dfs(s, dict, 0, new StringBuilder(), res, new boolean[s.length() + 1]);
        return res;
    }

    private void dfs(String s, Set<String> dict, int idx, StringBuilder path, List<String> res, boolean[] isInvalid) {
        if (idx == s.length()) {
            res.add(path.toString());
            return;
        }
        if (isInvalid[idx]) {
            return;
        }
        int len = path.length();
        int size = res.size();
        for (int i = idx + 1; i <= s.length(); i++) {
            String word = s.substring(idx, i);
            if (dict.contains(word)) {
                if (path.length() != 0) {
                    path.append(" ");
                }
                path.append(word);
                dfs(s, dict, i, path, res, isInvalid);
                path.setLength(len);
            }
        }
        if (size == res.size()) {
            isInvalid[idx] = true;
        }

    }

    public static void main(String[] args) {
        LC140 lc140 = new LC140();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc140.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")).toString());
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc140.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")).toString());
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc140.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")).toString());
        System.out.println();

        // Test Case 4
        System.out.println("Test case 4");
        System.out.println(lc140.wordBreak("aaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")).toString());
        System.out.println();
    }
}
