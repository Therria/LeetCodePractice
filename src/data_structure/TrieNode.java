package data_structure;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    public char ch;
    public TrieNode[] children;
    public boolean isWord;


    public TrieNode(char ch) {
        this.ch = ch;
        this.children = new TrieNode[26];
        this.isWord = false;

    }
}
