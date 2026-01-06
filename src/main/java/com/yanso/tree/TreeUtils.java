package com.yanso.tree;

import java.util.*;

public class TreeUtils {
    public static TreeNode fromArray(Integer[] array) {
        if (array == null || array.length == 0) return null;

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int i = 1;
        while (i < array.length) {
            TreeNode curr = queue.poll();

            // 处理左子节点
            if (i < array.length && array[i] != null) {
                curr.left = new TreeNode(array[i]);
                queue.add(curr.left);
            }
            i++;

            // 处理右子节点
            if (i < array.length && array[i] != null) {
                curr.right = new TreeNode(array[i]);
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        // 移除末尾多余的 null
        while (res.get(res.size() - 1).equals("null")) {
            res.remove(res.size() - 1);
        }
        System.out.println(res);
    }
}
