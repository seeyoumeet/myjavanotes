package com.seeyoumeet.study.leetcode;

import java.util.Arrays;

/**
 * @Classname Solution_Offer45_minNumber
 * @Description ：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * @Date ：2021-10-07
 * @Created by seeyoumeet
 */
public class Solution_Offer45_minNumber {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];

        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);  // 整型数组转换为字符数组

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));      // 对字符数组内的每一个字符，根据xy或yx拼接中比较小的那个进行排序

        StringBuilder res = new StringBuilder();

        for(String s : strs)
            res.append(s);      // 将排序后的字符数组拼接成字符串

        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Solution_Offer45_minNumber solution_offer45_minNumber = new Solution_Offer45_minNumber();
        String n = solution_offer45_minNumber.minNumber(nums);
    }
}
