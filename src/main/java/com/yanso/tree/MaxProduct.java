package com.yanso.tree;

public class MaxProduct {
    public static int MOD = 1000000007;
    public long result = Integer.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        long totalSum = dfsGetSum(root);
        dfs(root, totalSum);
        return (int) (result % MOD);
    }

    private long dfsGetSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfsGetSum(root.left) + dfsGetSum(root.right) + root.val;
    }

    private long dfs(TreeNode root, long totalSum) {
        if (root == null) {
            return 0;
        }
        long left = dfs(root.left, totalSum);
        long right = dfs(root.right, totalSum);
        long curSum = left + right + root.val;
        result = Math.max(result, curSum * (totalSum - curSum));
        return left + right + root.val;
    }

    public static void main(String[] args) {
        Integer[] rootArray = {1,null,2,3,4,null,null,5,6};
        TreeNode root = TreeUtils.buildFromArray(rootArray);
        TreeUtils.printTree(root);
        int result = new MaxProduct().maxProduct(root);
        System.out.println("result = " + result);
    }

}
