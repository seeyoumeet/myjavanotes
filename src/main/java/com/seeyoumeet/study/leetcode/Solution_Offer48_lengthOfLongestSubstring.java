package com.seeyoumeet.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_Offer48_lengthOfLongestSubstring
 * @Description ：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @Date ：2021-09-30
 * @Created by seeyoumeet
 */
public class Solution_Offer48_lengthOfLongestSubstring {

    // 方法一：动态规划 + 哈希表
    public int lengthOfLongestSubstringByDPAndHash(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j);        // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp);       // max(dp[j - 1], dp[j])
        }
        return res;
    }

    // 方法二： 动态规划 + 线性遍历
    public int lengthOfLongestSubstringByDPAndLinear(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--;    // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i;                // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp);                           // max(dp[j - 1], dp[j])
        }
        return res;
    }

    // 方法三：双指针 + 哈希表
    public int lengthOfLongestSubstringByPointerAndHash(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j)));  // 更新左指针 i
            dic.put(s.charAt(j), j);                    // 哈希表记录
            res = Math.max(res, j - i);                 // 更新结果
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_Offer48_lengthOfLongestSubstring solution_offer48_lengthOfLongestSubstring = new Solution_Offer48_lengthOfLongestSubstring();

        String s = "abcabcbb";
        int maxLength = solution_offer48_lengthOfLongestSubstring.lengthOfLongestSubstringByDPAndHash(s);
        System.out.println("字符串" + s + "中，最长的不包含重复字符的子串的最大长度是" + maxLength);
    }

}
