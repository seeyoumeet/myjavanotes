package com.seeyoumeet.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution_countPrimes204
 * @Description ：统计所有小于非负整数 n 的质数的数量
 * @Date ：2021-09-16
 * @Created by seeyoumeet
 */
public class Solution_countPrimes204 {

    // 1、使用枚举遍历 n 以内的质数
    public int countPrimesByEnum(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 2、使用埃氏筛
    public int countPrimesByErichsen(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);

        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        // 质数的整数倍为合数(如2是质数，则2*2、2*3、2*4都为合数，另外为了保证不重复赋值，从i*i开始，因为一半i*(i-1)已经被置为合数了
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    // 3、使用线性筛
    public int countPrimesByLinear(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];     // 存储某个数是不是质数

        Arrays.fill(isPrime, 1);    // 假设都是质数
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }

            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        Solution_countPrimes204 solution_countPrimes204 = new Solution_countPrimes204();
        int n = 10;

       int prime_count = solution_countPrimes204.countPrimesByEnum(n);
       System.out.println(n + "以内的质数有" + prime_count + "个");
    }
}
