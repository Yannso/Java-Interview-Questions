package com.yanso.slidingwindow;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] counts = new int[128];
        int maxLength = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (counts[c] == 0) {
                counts[c]++;
                right++;
            } else {
                maxLength = Math.max(maxLength, right - left);
                counts[s.charAt(left++)]--;
            }
        }
        return Math.max(maxLength, right - left);
    }

    public static void main(String[] args) {
        String testString = "pwwkew";
        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring(testString);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}
