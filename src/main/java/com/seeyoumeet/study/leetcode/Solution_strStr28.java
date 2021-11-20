package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_strStr28
 * @Description ：...
 * @Date ：2021-08-24
 * @Created by seeyoumeet
 */
public class Solution_strStr28 {

    /**
     * 使用 Java 模拟 KMP 字符串匹配算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        int[] pi = new int[m];      // 存储needle串中每个字符的真前缀
        for (int i = 1, j = 0; i < m; i++) {        // i从0开始，pi[0]默认为0，字符串的第一个字符的真前后缀默认为0
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;                // j值表示前缀所能涵盖的最大字符索引范围
            }
            pi[i] = j;
        }

        // i 指向needle，j指向haystack串，前者用于找出真前缀，后者用于找出真后缀
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_strStr28 solution_strStr28 = new Solution_strStr28();

        String haystack = "hello";
        String needle = "ll";
        int idx = solution_strStr28.strStr(haystack, needle);
        System.out.println("needle在haystack串出现的索引位置是：" + idx);
    }
}
