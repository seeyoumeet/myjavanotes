package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_reverseString344
 * @Description ：...
 * @Date ：2021-08-21
 * @Created by seeyoumeet
 */
public class Solution_reverseString344 {

    // 使用对称翻转(只需要遍历字符数组长度的一半，时间复杂度为2 / n)
    public void reverseString1(char[] s) {
        int length = s.length;

        char temp;
        for (int i = 0; i < length/2; i++) {
            temp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = temp;
        }
    }

    // 使用双指针（其实也是对称翻转的一种）
    public void reverseString2(char[] s) {
        int left = 0, right = s.length-1;

        while(left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution_reverseString344 solution_reverseString344 = new Solution_reverseString344();

        char[] s = {'h','e','l','l','o'};
        solution_reverseString344.reverseString1(s);

        System.out.println(s);

        solution_reverseString344.reverseString2(s);

        System.out.println(s);
    }
}
