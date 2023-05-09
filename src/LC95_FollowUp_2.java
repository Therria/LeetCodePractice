import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
MyTree {binary tree, only 0 or 2 children}, given num of leaves n, return all possible MyTree.
Each node of each tree in the answer must have Node.val == 0.
==> LC894
 */
public class LC95_FollowUp_2 {
    public List<TreeNode> genMyTree(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            List<TreeNode> res = new LinkedList<>();
            res.add(null);
            return res;
        }
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i = 1; i < n; i++) {
            List<TreeNode> lefts = dfs(i);
            List<TreeNode> rights = dfs(n - i);
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
        LC95_FollowUp_2 lc95_followUp_2 = new LC95_FollowUp_2();

        // test case 1
        System.out.println("Test Case 1");
        List<TreeNode> list1 = lc95_followUp_2.genMyTree(0);
        System.out.println("Output: ");
        for(TreeNode root: list1) {
            System.out.print("  ");
            TreeGenerator.toList(root);
        }
        System.out.println();

        // test case 2
        System.out.println("Test Case 2");
        List<TreeNode> list2 = lc95_followUp_2.genMyTree(4);
        System.out.println("Output: ");
        for(TreeNode root: list2) {
            System.out.print("  ");
            TreeGenerator.toList(root);
        }
        System.out.println();
    }
}
