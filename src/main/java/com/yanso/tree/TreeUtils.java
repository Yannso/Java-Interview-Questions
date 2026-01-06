package com.yanso.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeUtils {
    public static TreeNode fromArray(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return dfsCreateTree(array,0);
    }

    private static TreeNode dfsCreateTree(Integer[] array, int i) {
        if (i >= array.length || array[i] == null) {
            return null;
        }
        TreeNode rootNode = new TreeNode(array[i]);
        rootNode.left = dfsCreateTree(array, 2 * i + 1);
        rootNode.right = dfsCreateTree(array, 2 * i + 2);
        return rootNode;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode current = deque.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                deque.offer(current.left);
            }
            if (current.right != null) {
                deque.offer(current.right);
            }
        }
        System.out.println();
    }
}
