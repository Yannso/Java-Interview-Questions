package com.yanso.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 1. 边界处理：如果 s 比 p 还短，绝对不可能存在异位词
        if (s == null || s.length() < p.length()) {
            return res;
        }

        int[] counts_p = new int[26];
        int[] counts_s = new int[26];

        int requiredMatches = 0; // p 中有多少种不重复的字符
        for (char c : p.toCharArray()) {
            if (counts_p[c - 'a'] == 0) {
                requiredMatches++;
            }
            counts_p[c - 'a']++;
        }

        int left = 0, right = 0;
        int currentMatches = 0; // 当前窗口内有多少种字符达到了 p 所要求的频次

        // 3. 开始滑动窗口
        while (right < s.length()) {
            // --- 【入窗口】操作 ---
            char c = s.charAt(right);
            int idx = c - 'a';
            counts_s[idx]++;

            // 如果该字符在 s 中的数量刚好达到了 p 中的要求，match 数加 1
            if (counts_s[idx] == counts_p[idx]) {
                currentMatches++;
            }
            right++;

            // 只要窗口长度等于 p.length()，就进行判断和左侧移出
            if (right - left == p.length()) {
                // 判断：如果所有字符种类都匹配上了，记录起始索引
                if (currentMatches == requiredMatches) {
                    res.add(left);
                }

                // --- 【出窗口】操作 ---
                char d = s.charAt(left);
                int leftIdx = d - 'a';

                // 关键点：如果当前字符刚好符合要求，由于它要出窗口了，match 数必须减 1
                if (counts_s[leftIdx] == counts_p[leftIdx]) {
                    currentMatches--;
                }
                counts_s[leftIdx]--;
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String testString = "abab";
        String pattern = "ab";
        List<Integer> result = new FindAnagrams().findAnagrams(testString, pattern);
        System.out.println("Anagram indices: " + result);
    }
}
