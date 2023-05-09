import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class LC549 {
    private int max;

    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        max = 0;
        dfs(root);
        return max;
    }

    // index_0: len of increasing path starting from cur top-down
    // index_1: len of decreasing path starting from cur top-down
    private int[] dfs(TreeNode cur) {

        if (cur == null) {
            return null;
        }

        int[] res = new int[]{1, 1};
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);

        if (left != null) {
            if (cur.left.val - cur.val == 1) {
                res[0] += left[0];
            } else if (cur.left.val - cur.val == -1) {
                res[1] += left[1];
            }
        }

        if (right != null) {
            if (cur.right.val - cur.val == 1) {
                res[0] = Math.max(res[0], right[0] + 1);
            } else if (cur.right.val - cur.val == -1) {
                res[1] = Math.max(res[1], right[1] + 1);
            }
        }

        max = Math.max(max, res[0] + res[1] - 1);
        return res;
    }

    public static void main(String[] args) {
        LC549 lc549 = new LC549();

        // test case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println("Output: " + lc549.longestConsecutive(root1));
        System.out.println();

        // test case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(new ArrayList<>(Arrays.asList(2,null,3,2,1)));
        System.out.println("Output: " + lc549.longestConsecutive(root2));
        System.out.println();
    }
}
