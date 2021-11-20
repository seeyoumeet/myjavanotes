package com.seeyoumeet.study.leetcode;

import java.util.Arrays;

/**
 * @Classname Solution_isAnagram242
 * @Description ：有效的字母异位词
 * @Date ：2021-08-31
 * @Created by seeyoumeet
 */
public class Solution_isAnagram242 {

    // t 是 s 的异位词等价于「两个字符串排序后相等」
    public boolean isAnagramBySort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    // 通过哈希表，t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」
    public boolean isAnagramByMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];      // 维护一份26个字母的数组
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;     // 得到字符串s中每个字符出现的次数
        }

        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {     // 看s与t的各字符出现次数是否相同
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_isAnagram242 solution_isAnagram242 = new Solution_isAnagram242();

        String s = "anagram", t = "nagaram";
        solution_isAnagram242.isAnagramBySort(s, t);
        solution_isAnagram242.isAnagramByMap(s, t);
    }
}
