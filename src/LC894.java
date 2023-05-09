import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.LinkedList;
import java.util.List;

public class LC894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        return dfs(n);
    }

    public List<TreeNode> dfs(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < n - 1; i++) {
            List<TreeNode> lefts = dfs(i);
            List<TreeNode> rights = dfs(n - 1 - i);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LC894 lc894 = new LC894();

        // test case 1
        System.out.println("Test Case 1");
        List<TreeNode> list1 = lc894.allPossibleFBT(7);
        System.out.println("Output: ");
        for(TreeNode root: list1) {
            System.out.print("  ");
            TreeGenerator.toList(root);
        }
        System.out.println();

        // test case 2
        System.out.println("Test Case 2");
        List<TreeNode> list2 = lc894.allPossibleFBT(3);
        System.out.println("Output: ");
        for(TreeNode root: list2) {
            System.out.print("  ");
            TreeGenerator.toList(root);
        }
        System.out.println();
    }
}
