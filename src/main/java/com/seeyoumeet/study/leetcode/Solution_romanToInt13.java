package com.seeyoumeet.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_romanToInt13
 * @Description ：罗马数字转整数
 * @Date ：2021-09-14
 * @Created by seeyoumeet
 */
public class Solution_romanToInt13 {

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    //  XXVII 可视作 X+X+I+I+I= 10+10+5+1+1=27
    public int romanToInt(String s) {
        int ans = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));  // 先将罗马数字中的字母替换为数字
            // 若较小的数字出现在较大的数字左边，则需要减去小的数字
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;       // 否则合计值就是累加
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_romanToInt13 solution_romanToInt13 = new Solution_romanToInt13();

        String s = "LVIII";
        int num = solution_romanToInt13.romanToInt(s);
        System.out.println("罗马数字s(" + s + ")转换为数字为：" + num);
    }
}
