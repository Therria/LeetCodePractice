package generator;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeGenerator {
    public static TreeNode generate(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < list.size(); i += 2) {
            TreeNode cur = queue.poll();
            Integer leftVal = list.get(i);
            Integer rightVal = i + 1 < list.size() ? list.get(i + 1) : null;

            if (leftVal != null) {
                cur.left = new TreeNode(leftVal);
                queue.offer(cur.left);
            } else {
                cur.left = null;
            }

            if (rightVal != null) {
                cur.right = new TreeNode(rightVal);
                queue.offer(cur.right);
            } else {
                cur.right = null;
            }
        }

        return root;
    }

    public static List<Integer> toList(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            list.add(cur == null ? null : cur.val);
        }
        System.out.println(list.toString());
        return list;
    }
}
