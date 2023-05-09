import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class LC333 {
    class Result {
        int min;
        int max;
        int size;
        Result() {}
        Result(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    private int maxSize;

    public int largestBSTSubtree(TreeNode root) {
        // corner case
        if (root == null) {
            return 0;
        }
        maxSize = 0;
        dfs(root);
        return maxSize;
    }

    private Result dfs(TreeNode cur) {
        if (cur == null) {
            return new Result(0, 0, 0);
        }

        Result left = dfs(cur.left);
        Result right = dfs(cur.right);
        if (left == null || right == null) {
            return null;
        }

        if ((left.size != 0 && left.max >= cur.val) || (right.size != 0 && right.min <= cur.val)) {
            return null;
        }

        int size = left.size + right.size + 1;
        int min = left.size > 0 ? left.min : cur.val;
        int max = right.size > 0 ? right.max : cur.val;
        maxSize = Math.max(maxSize, size);

        return new Result(min, max, size);
    }

    public static void main(String[] args) {
        LC333 lc333 = new LC333();

        // test case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(new ArrayList<>(Arrays.asList(10,5,15,1,8,null,7)));
        System.out.println("Output: " + lc333.largestBSTSubtree(root1));
        System.out.println();

        // test case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(new ArrayList<>(Arrays.asList(4,2,7,2,3,5,null,2,null,null,null,null,null,1)));
        System.out.println("Output: " + lc333.largestBSTSubtree(root2));
        System.out.println();
    }
}
