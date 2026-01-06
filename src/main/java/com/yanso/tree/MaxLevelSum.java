package com.yanso.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int curLevel = 1;
        int maxSumLevel = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int curSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = deque.poll();
                curSum += curNode.val;
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
            }
            if (maxSum < curSum) {
                maxSum = curSum;
                maxSumLevel = curLevel;
            }
            curLevel++;
        }
        return maxSumLevel;
    }

    public static void main(String[] args) {
        Integer[] rootArray = {-100,-200,-300,-20,-5,-10,null};
        TreeNode root = TreeUtils.fromArray(rootArray);
        TreeUtils.printTree(root);
        int result = new MaxLevelSum().maxLevelSum(root);
        System.out.println("result = " + result);
    }
}
