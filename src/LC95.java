import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LC95 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = dfs(start, i - 1);
            List<TreeNode> rights = dfs(i + 1, end);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC95 lc95 = new LC95();

        // test case 1
        System.out.println("Test Case 1");
        List<TreeNode> list1 = lc95.generateTrees(3);
        System.out.println("Output: ");
        for(TreeNode root: list1) {
            System.out.print("  ");
            TreeGenerator.toList(root);
        }
        System.out.println();

        // test case 2
        System.out.println("Test Case 2");
        List<TreeNode> list2 = lc95.generateTrees(1);
        System.out.println("Output: ");
        for(TreeNode root: list2) {
            System.out.print("  ");
            TreeGenerator.toList(root);
        }
        System.out.println();
    }
}
