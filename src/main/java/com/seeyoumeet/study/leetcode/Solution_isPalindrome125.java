package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_isPalindrome125
 * @Description ：...
 * @Date ：2021-08-22
 * @Created by seeyoumeet
 */
public class Solution_isPalindrome125 {

    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {      // 转换字符串字符
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }

        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());       // 回文串：字符串翻转前与翻转后的字符串相同
    }

    public static void main(String[] args) {
        Solution_isPalindrome125 solution_isPalindrome125 = new Solution_isPalindrome125();

        String s1 = "A man, a plan, a canal: Panama";
        boolean is_palindrome = solution_isPalindrome125.isPalindrome(s1);
        System.out.println("是否为回文串：" + is_palindrome);

        String s2 = "race a car";
        is_palindrome = solution_isPalindrome125.isPalindrome(s2);
        System.out.println("是否为回文串：" + is_palindrome);
    }
}
