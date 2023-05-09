package generator;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeDrawer {
    public static void draw(TreeNode root) {
        drawTree(root, "");
    }

    private static void drawTree(TreeNode node, String prefix) {
        if (node == null) {
            System.out.println(prefix + "╴");
            return;
        }

        System.out.println(prefix + "┌──" + node.val);
        drawTree(node.left, prefix + "│  ");
        drawTree(node.right, prefix + "   ");
    }


}
