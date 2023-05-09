import java.util.HashMap;
import java.util.Map;

public class LC294 {

    public boolean canWin(String currentState) {
        return dfs(currentState.toCharArray(), new HashMap<>());
    }

    private boolean dfs(char[] board, Map<String, Boolean> mem) {
        String cur = String.valueOf(board);
        Boolean status = mem.get(cur);
        if (status != null) {
            return status;
        }
        for (int i = 0; i < board.length - 1 ; i++) {
            if (board[i] == '+' && board[i + 1] == '+') {
                board[i] = '-';
                board[i + 1] = '-';
                boolean opponent = dfs(board, mem);
                board[i] = '+';
                board[i + 1] = '+';
                if (!opponent) {
                    mem.put(cur, true);
                    return true;
                }
            }
        }
        mem.put(cur, false);
        return false;
    }

    public static void main(String[] args) {
        LC294 lc294 = new LC294();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc294.canWin("++++"));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc294.canWin("+"));
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc294.canWin("++"));
        System.out.println();
    }
}
