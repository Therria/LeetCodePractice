import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.Arrays;
/*
LC285 + target not on the tree handling
 */
public class LC285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // corner case
        if (root == null || p == null) {
            throw new IllegalArgumentException();
        }
        TreeNode res = null;
        TreeNode cur = root;
        boolean foundTarget = false;
        while (cur != null) {
            if (cur.val <= p.val) {
                if (cur == p) {
                    foundTarget = true;
                }
                cur = cur.right;
            } else {
                res = cur;
                cur = cur.left;
            }
        }
        if (!foundTarget) {
            throw new RuntimeException("Target is not on the given tree");
        }
        return res;
    }

    public static void main(String[] args) {
        LC285 lc285 = new LC285();

        // Test Case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(Arrays.asList(2,1,3));
        TreeNode target1 = root1.left;
        TreeNode res1 = lc285.inorderSuccessor(root1, target1);
        if (res1 != null){
            System.out.println("Output: " + res1.val);
        } else {
            System.out.println("Output: " + null);
        }
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(Arrays.asList(5,3,6,2,4,null,null,1));
        TreeNode target2 = root2.right;
        TreeNode res2 = lc285.inorderSuccessor(root2, target2);
        if (res2 != null){
            System.out.println("Output: " + res2.val);
        } else {
            System.out.println("Output: " + null);
        }
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3 (target not on tree)");
        TreeNode root3 = TreeGenerator.generate(Arrays.asList(5,3,6,2,4,null,null,1));
        // TreeNode target3 = root3.left;
        TreeNode target3 = new TreeNode(3);
        TreeNode res3 = lc285.inorderSuccessor(root3, target3);
        if (res3 != null){
            System.out.println("Output: " + res3.val);
        } else {
            System.out.println("Output: " + null);
        }
        System.out.println();
    }
}
