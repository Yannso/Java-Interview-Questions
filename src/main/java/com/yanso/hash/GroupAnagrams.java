package com.yanso.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // 字符串的 字符频率数组 进行编码作为Map的key，保证唯一性
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }
            // 1. 将频率数组转为字符串作为 Key
            StringBuilder sb = new StringBuilder();
            for (int count : counts) {
                sb.append(count).append("#"); // count可能是多位数，加分隔符，区分上一个字符出现频率
            }
            System.out.println("sb = " + sb);
            // 2. 分组
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // List<List<String>> list = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> list = new GroupAnagrams().groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        System.out.println(list);
    }
}
