import data_structure.TrieNode;

public class LC211 {
    TrieNode root;

    public LC211() {
        this.root = new TrieNode('\0');
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode(ch);
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode cur) {
        // base case
        if (cur == null) {
            return false;
        }
        if (idx == word.length()) {
            return cur.isWord;
        }
        char ch = word.charAt(idx);
        if (ch != '.') {
            TrieNode next = cur.children[ch - 'a'];
            if (next == null) {
                return false;
            }
            return dfs(word, idx + 1, next);
        } else {
            for (TrieNode next: cur.children) {
                if (dfs(word, idx + 1, next)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LC211 lc211 = new LC211();

        // Test Case 1
        System.out.println("Test Case 1");
        lc211.addWord("bad");
        lc211.addWord("dad");
        lc211.addWord("mad");
        System.out.println(lc211.search("pad"));
        System.out.println(lc211.search("bad"));
        System.out.println(lc211.search(".ad"));
        System.out.println(lc211.search("b.."));
        System.out.println();

    }
}
