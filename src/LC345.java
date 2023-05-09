import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        char[] ss = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!vowels.contains(ss[start])) {
                start++;
                continue;
            }
            if (!vowels.contains(ss[end])) {
                end--;
                continue;
            }
            swap(ss, start++, end--);
        }
        return new String(ss);
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        LC345 lc345 = new LC345();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc345.reverseVowels("hello"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc345.reverseVowels("Apple"));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc345.reverseVowels("lEetcode"));
        System.out.println();
    }
}
