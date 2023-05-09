import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.*;

/*
=> LC653
 */
public class LC272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // corner case
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Deque<TreeNode> lStack = new ArrayDeque<>();
        Deque<TreeNode> rStack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < target) {
                lStack.offerFirst(cur);
                cur = cur.right;
            } else {
                rStack.offerFirst(cur);
                cur = cur.left;
            }
        }
        List<Integer> res = new LinkedList<>();
        boolean isLeftEmpty = false;
        while (k-- > 0) {
            if (!lStack.isEmpty() && !rStack.isEmpty()) {
                TreeNode l = lStack.peekFirst();
                TreeNode r = rStack.peekFirst();
                if (Math.abs(l.val - target) < Math.abs(r.val - target)) {
                    res.add(leftShift(lStack));
                } else {
                    res.add(rightShift(rStack));
                }
            } else if (!lStack.isEmpty()) {
                res.add(leftShift(lStack));
            } else if (!rStack.isEmpty()) {
                res.add(rightShift(rStack));
            } else {
                throw new RuntimeException("Invalid Input: k > n");
            }
        }
        return res;

    }

    private int leftShift(Deque<TreeNode> stack) {
        TreeNode top = stack.pollFirst();
        TreeNode cur = top.left;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.right;
        }
        return top.val;
    }

    private int rightShift(Deque<TreeNode> stack) {
        TreeNode top = stack.pollFirst();
        TreeNode cur = top.right;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
        return top.val;
    }


    public static void main(String[] args) {
        LC272 lc272 = new LC272();

        // Test case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(Arrays.asList(4,2,5,1,3));
        List<Integer> list1 = lc272.closestKValues(root1, 3.714286, 2);
        System.out.println("Output: " + list1.toString());
        System.out.println();

        // Test case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(Arrays.asList(1));
        List<Integer> list2 = lc272.closestKValues(root2, 0.000000, 1);
        System.out.println("Output: " + list2.toString());
        System.out.println();


    }
}
