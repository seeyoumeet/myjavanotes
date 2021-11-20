package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_Offer10_fib
 * @Description ：写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项
 * @Date ：2021-09-28
 * @Created by seeyoumeet
 */
public class Solution_Offer10_fib {

    // 使用动态规划
    public int fib(int n) {
        final int MOD = 1000000007;

        if (n < 2) {
            return n;   // F(0) = 0, F(1) = 1
        }

        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;          // F(n) = F(n−1) + F(n−2)
        }
        return r;
    }

    public static void main(String[] args) {
        Solution_Offer10_fib solution_offer10_fib = new Solution_Offer10_fib();

        int n = 10;
        solution_offer10_fib.fib(n);
    }
}
