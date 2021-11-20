package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_isPowerOfThree
 * @Description ：给定一个整数，写一个函数来判断它是否是 3 的幂次方
 * @Date ：2021-09-19
 * @Created by seeyoumeet
 */
public class Solution_isPowerOfThree {

    // 方法一：循环迭代
    public boolean isPowerOfThreeByIterator(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {    // 每次除3的余数的余数都是0
            n /= 3;
        }

        return n == 1;
    }

    // 方法二：基准转换
    public boolean isPowerOfThreeByBaseChange(int n) {
        // 先将n转换为以3为基底的数字，就是将n表示为3进制数的形式，然后检查这个3进制数是否是以1开头并后接0个或n个0的字符串
        return Integer.toString(n, 3).matches("^10*$");
    }

    // 方法三：运算法
    public boolean isPowerOfThreeByCalc(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;    // 根据公式，若n是3的整数，则(Math.log10(n) / Math.log10(3))的值一定为整数，% 1用于检查数值是否为整数
    }

    public static void main(String[] args) {
        Solution_isPowerOfThree solution_isPowerOfThree = new Solution_isPowerOfThree();

        int n = 109;
        boolean is3 = solution_isPowerOfThree.isPowerOfThreeByIterator(n);
        System.out.println(n + (is3 ? "是" : "不是") + "3的幂数");

        n = 81;
        is3 = solution_isPowerOfThree.isPowerOfThreeByBaseChange(n);
        System.out.println(n + (is3 ? "是" : "不是") + "3的幂数");
    }
}
