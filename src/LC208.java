import generator.Trie;

public class LC208 {
    /*
    Implementation in generator/Trie
     */

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Test Case 1
        System.out.println("Test Case 1");
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println();

    }
}
