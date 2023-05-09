import data_structure.TreeNode;
import data_structure.TrieNode;
import generator.TreeGenerator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
LC285 : given an arbitrary binary tree and a target TreeNode p, find its in-order successor
 */
public class LC285_FollowUp {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Deque<TreeNode> stack = initialStack(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = shift(stack);
            if (pre == p) {
                return cur;
            }
            pre = cur;
        }
        if (pre != p) {
            throw new RuntimeException("Target is not on the tree");
        }
        return null;
    }

    private Deque<TreeNode> initialStack(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
        return stack;
    }

    private TreeNode shift(Deque<TreeNode> stack) {
        TreeNode top = stack.poll();
        TreeNode cur = top.right;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
        return top;
    }

    public static void main(String[] args) {
        LC285_FollowUp lc285_followUp = new LC285_FollowUp();

        // Test Case 1
        System.out.println("Test case 1");
        TreeNode root1 = TreeGenerator.generate(Arrays.asList(1,2,3,4,5));
        TreeNode p1 = root1.left.right;
        TreeNode res1 = lc285_followUp.inorderSuccessor(root1, p1);
        if (res1 == null) {
            System.out.println("Output: " + null);
        } else {
            System.out.println("Output: " + res1.val);
        }
        System.out.println();


        // Test Case 2
        System.out.println("Test case 2");
        TreeNode root2 = TreeGenerator.generate(Arrays.asList(1,2,3,4,5));
        TreeNode p2 = root2.right;
        TreeNode res2 = lc285_followUp.inorderSuccessor(root2, p2);
        if (res2 == null) {
            System.out.println("Output: " + null);
        } else {
            System.out.println("Output: " + res2.val);
        }
        System.out.println();

        // Test Case 3
        System.out.println("Test case 3: target not on the tree");
        TreeNode root3 = TreeGenerator.generate(Arrays.asList(1,2,3,4,5));
        TreeNode p3 = new TreeNode(1);
        TreeNode res3 = lc285_followUp.inorderSuccessor(root3, p3);
        if (res3 == null) {
            System.out.println("Output: " + null);
        } else {
            System.out.println("Output: " + res3.val);
        }
        System.out.println();
    }

}
