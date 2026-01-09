package com.yanso.tree;

public class SubtreeWithAllDeepest {

    static class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node) {
        if (node == null) return new Result(null,0);
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }
        if (right.depth > left.depth) {
            return new Result(right.node, right.depth + 1);
        }
        return new Result(node, left.depth + 1);
    }

    public static void main(String[] args) {
        // Integer[] treeNodeArray = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        // Integer[] treeNodeArray = {0,3,1,4,null,2,null,null,6,null,5};
        Integer[] treeNodeArray = {0,1,3,null,2};
        TreeNode root = TreeUtils.buildFromArray(treeNodeArray);
        TreeNode treeNode = new SubtreeWithAllDeepest().subtreeWithAllDeepest(root);
        TreeUtils.printTree(treeNode);
    }
}
