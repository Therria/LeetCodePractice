import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/*
=> LC272
 */
public class LC653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Deque<TreeNode> lStack = initialL(root);
        Deque<TreeNode> rStack = initialR(root);
        while(!lStack.isEmpty() && !lStack.isEmpty()) {
            TreeNode l = lStack.peekFirst();
            TreeNode r = rStack.peekFirst();
            if (l == r) {
                break;
            }
            int sum = l.val + r.val;
            if (sum > k) {
                rightMinusShift(rStack);
            } else if (sum < k) {
                leftPlusShift(lStack);
            } else {
                return true;
            }
        }

        return false;
    }

    private Deque<TreeNode> initialL(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
        return stack;
    }

    private Deque<TreeNode> initialR(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null) {
            stack.offerFirst(root);
            root = root.right;
        }
        return stack;
    }

    private void leftPlusShift(Deque<TreeNode> stack) {
        TreeNode top = stack.pollFirst();
        TreeNode cur = top.right;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
        return;
    }

    private void rightMinusShift(Deque<TreeNode> stack) {
        TreeNode top = stack.pollFirst();
        TreeNode cur = top.left;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.right;
        }
        return;
    }

    public static void main(String[] args) {
        LC653 lc653 = new LC653();

        // Test Case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(Arrays.asList(5,3,6,2,4,null,7));
        System.out.println("Output: " + lc653.findTarget(root1, 9));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(Arrays.asList(5,3,6,2,4,null,7));
        System.out.println("Output: " + lc653.findTarget(root1, 28));
        System.out.println();
    }
}
