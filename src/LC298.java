import data_structure.TreeNode;
import generator.TreeDrawer;
import generator.TreeGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class LC298 {

    private int max;
    public int longestConsecutive(TreeNode root) {
        //corner case
        if (root == null) {
            return 0;
        }
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }

        int left = dfs(cur.left);
        int right = dfs(cur.right);

        int len = 1;
        if (cur.left != null && cur.val == cur.left.val - 1) {
            len = left + 1;
        }

        if (cur.right != null && cur.val == cur.right.val - 1) {
            len = Math.max(len,  right + 1);
        }

        max = Math.max(max, len);

        return len;
    }
    public static void main(String[] args) {
        LC298 lc298 = new LC298();

        // test case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(new ArrayList<>(Arrays.asList(1,null,3,2,4,null,null,null,5)));
        System.out.println("Output: " + lc298.longestConsecutive(root1));
        System.out.println();

        // test case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(new ArrayList<>(Arrays.asList(2,null,3,2,null,1)));
        System.out.println("Output: " + lc298.longestConsecutive(root2));
        System.out.println();
    }
}
