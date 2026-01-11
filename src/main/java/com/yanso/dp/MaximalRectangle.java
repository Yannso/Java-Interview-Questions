package com.yanso.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[n + 1];
        Deque<Integer> stack;
        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            System.out.println(Arrays.toString(heights));
            stack = new ArrayDeque<>();
            stack.offerLast(-1);
            for (int j = 0; j < n + 1; j++) {
                while (!stack.isEmpty() && heights[j] < heights[stack.peekLast()]) {
                    int top = stack.pollLast();
                    // 左边界：左边的柱子是以栈顶柱子高度 h为矩形时的 “左墙”，无法横跨
                    // 右边界：正在遍历的柱子j是以栈顶柱子高度 h为矩形时的“右墙”，无法横跨
                    // 如果左边界为空（栈为空），意味着栈顶柱子高度h可以横跨0~j-1，即j
                    int w = stack.isEmpty() ? j : j - stack.peekLast() - 1;
                    maxArea = Math.max(maxArea, heights[top] * w);
                }
                stack.offerLast(j);
            }
            System.out.println("maxArea = " + maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int result = new MaximalRectangle().maximalRectangle(matrix);
        System.out.println("result = " + result);
    }
}
