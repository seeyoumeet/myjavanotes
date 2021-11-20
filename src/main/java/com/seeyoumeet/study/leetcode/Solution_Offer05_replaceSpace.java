package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_Offer05_replaceSpace
 * @Description ：...
 * @Date ：2021-09-20
 * @Created by seeyoumeet
 */
public class Solution_Offer05_replaceSpace {

    // 1、使用辅助字符数组
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);       // 对于字符串s中的每个字符，根据其是否为' '空格，生成一个新的字符数组
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }

        String newStr = new String(array, 0, size);

        return newStr;
    }

    public static void main(String[] args) {
        Solution_Offer05_replaceSpace solution_offer05_replaceSpace = new Solution_Offer05_replaceSpace();

        String s = "We are happy.";
        String s_replace = solution_offer05_replaceSpace.replaceSpace(s);
        System.out.println(s_replace);
    }
}
