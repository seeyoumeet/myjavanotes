package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_Offer67_strToInt
 * @Description ：写一个函数 StrToInt，实现把字符串转换成整数这个功能
 * @Date ：2021-09-27
 * @Created by seeyoumeet
 */
public class Solution_Offer67_strToInt {

    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;

        if(c[0] == '-') {
            sign = -1;
        } else if(c[0] != '+') {
            i = 0;
        }

        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') {
                break;
            }

            if(res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        Solution_Offer67_strToInt solution_offer67_strToInt = new Solution_Offer67_strToInt();

        String s = "-45";
        int n = solution_offer67_strToInt.strToInt(s);
        System.out.println("字符串：" + s + "转换为数字：" + n);
    }
}
