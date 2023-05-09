package generator;

import data_structure.TrieNode;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()){
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode(ch);
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
        print();
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            int idx = ch - 'a';
            TrieNode next = cur.children[idx];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch: prefix.toCharArray()) {
            int idx = ch - 'a';
            TrieNode next = cur.children[idx];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return true;
    }

    public void print() {
        List<String> res = new LinkedList<>();
        dfs(root, new StringBuilder(), res);
        System.out.println("The trie contains: " + res.toString());
    }

    private void dfs(TrieNode cur, StringBuilder path, List<String> res) {
        if (cur == null) {
            return;
        }
        int len = path.length();
        path.append(cur.ch);
        if (cur.isWord) {
            res.add(path.substring(1));
        }
        for (TrieNode next: cur.children) {
            dfs(next, path, res);
        }
        path.setLength(len);
    }
}
