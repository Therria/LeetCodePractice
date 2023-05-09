import java.util.*;

public class LC241 {
    private final Set<Character> OPERATORS = new HashSet(Arrays.asList('+', '-', '*', '/'));

    public List<Integer> diffWaysToCompute(String expression) {
        // corner case
        if (expression == null || expression.length() == 0) {
            throw new IllegalArgumentException();
        }

        return dfs(expression, 0, expression.length() - 1);
    }

    private List<Integer> dfs(String ex, int start, int end) {
        List<Integer> res = new LinkedList<>();
        // base case
        if (start > end) {
            throw new RuntimeException("Invalid input");
        }

        boolean isPureDigit = true;
        for (int i = start; i <= end; i++) {
            char ch = ex.charAt(i);
            if (OPERATORS.contains(ch)) {
                isPureDigit = false;
                List<Integer> left = dfs(ex, start, i - 1);
                List<Integer> right = dfs(ex, i + 1, end);
                for (int l: left) {
                    for (int r: right) {
                        res.add(cal(ch, l, r));
                    }
                }
            }
        }
        if (isPureDigit) {
            res.add(Integer.parseInt(ex.substring(start, end + 1)));
        }
        return res;
    }

    private int cal(char op, int n1, int n2) {
        switch(op) {
            case '+': n1 += n2; break;
            case '-': n1 -= n2; break;
            case '*': n1 *= n2; break;
            // case '/': n1 /= n2; break;
            default: throw new IllegalArgumentException();
        }
        return n1;
    }

    public static void main(String[] args) {
        LC241 lc241 = new LC241();

        // Test Case 1
        System.out.println("Test Case 1");
        List<Integer> list1 = lc241.diffWaysToCompute("2-1-1");
        System.out.println("Output: " + list1.toString());
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        List<Integer> list2 = lc241.diffWaysToCompute("2*3-4*5");
        System.out.println("Output: " + list2.toString());
        System.out.println();
    }
}
