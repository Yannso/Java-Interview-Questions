package com.yanso.twopoint;

public class MaxArea {
    public int maxArea(int[] height) {
        // 贪心思想
        int maxarea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            maxarea = Math.max(maxarea, curArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = new MaxArea().maxArea(height);
        System.out.println("area = " + area);
    }
}
