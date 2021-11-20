package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_reverse7
 * @Description ：整数反转
 * @Date ：2021-08-31
 * @Created by seeyoumeet
 */
public class Solution_reverse7 {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;         // 取出整数的末位
            x /= 10;
            rev = rev * 10 + digit;     // 逐位重新封装整数
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution_reverse7 solution_reverse7 = new Solution_reverse7();

        int x = 213712109;
        System.out.println(solution_reverse7.reverse(x));
    }
}
