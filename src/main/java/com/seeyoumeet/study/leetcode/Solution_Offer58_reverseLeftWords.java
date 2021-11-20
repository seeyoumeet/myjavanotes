package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_Offer58_reverseLeftWords
 * @Description ：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
 * @Date ：2021-09-25
 * @Created by seeyoumeet
 */
public class Solution_Offer58_reverseLeftWords {

    // 方法一：字符串切片
    public String reverseLeftWordsBySplit(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);      // 0-5 --> [2,5] + [0,1]
    }

    // 方法二：列表遍历拼接
    public String reverseLeftWordsByIter(String s, int n) {
        StringBuilder res = new StringBuilder();

        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));

        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    public static void main(String[] args) {
        String letter = "abcdefg";
        int n = 2;

        Solution_Offer58_reverseLeftWords solution_offer58_reverseLeftWords = new Solution_Offer58_reverseLeftWords();
        solution_offer58_reverseLeftWords.reverseLeftWordsBySplit(letter, n);
        solution_offer58_reverseLeftWords.reverseLeftWordsByIter(letter, n);
    }
}
