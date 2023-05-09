import data_structure.TreeNode;
import generator.TreeGenerator;

import java.util.Arrays;
import java.util.List;

public class LC270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        TreeNode cur = root;
        int closest = root.val;
        while (cur != null) {
            if (Math.abs(cur.val - target) <= Math.abs(closest - target)) {
                closest = cur.val;
            }
            if (cur.val < target) {
                cur = cur.right;
            } else if (cur.val > target) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        LC270 lc270 = new LC270();

        // Test case 1
        System.out.println("Test Case 1");
        TreeNode root1 = TreeGenerator.generate(Arrays.asList(4,2,5,1,3));
        System.out.println("Output: " + lc270.closestValue(root1, 3.714286));
        System.out.println();

        // Test case 2
        System.out.println("Test Case 2");
        TreeNode root2 = TreeGenerator.generate(Arrays.asList(1));
        System.out.println("Output: " + lc270.closestValue(root2, 4.428571));
        System.out.println();


    }
}
