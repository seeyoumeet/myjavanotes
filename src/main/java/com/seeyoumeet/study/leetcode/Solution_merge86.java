package com.seeyoumeet.study.leetcode;

import java.util.Arrays;

/**
 * @Classname Solution_merge86
 * @Description ：...
 * @Date ：2021-09-12
 * @Created by seeyoumeet
 */
public class Solution_merge86 {

    // 直接合并后排序
    public void mergeByMerge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; i++) {
            nums1[m + i] = nums2[i];        // 把nums2放到nums1后面
        }
        Arrays.sort(nums1);
    }

    // 使用双指针(类似对有序链表做合并操作)
    public void mergeByTwoPointer(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;                 // 数组的索引取值也可以看作是指针
        int[] sorted = new int[m + n];      // 合并后的数组

        int cur;
        while (p1 < m || p2 < n) {          // p1、p2任一指针还未到末尾
            if (p1 == m) {                  // nums1首先取值完毕
                cur = nums2[p2++];
            } else if (p2 == n) {           // nums2首先取值完毕，p2不变，p1++将nums1并入数组
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {     // 取nums1和nums2中较小的值
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {      // nums1的初始长度为 m+n
            nums1[i] = sorted[i];               // 复制sorted数组
        }
    }

    // 使用逆向双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {    // p1、p2任意指
            // 针还未到头部
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) { // 从末尾开始，取nums1和nums2中较大的值
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        Solution_merge86 solution_merge86 = new Solution_merge86();

        int[] nums1 = { 1,2,3,0,0,0 };
        int m = 3;

        int[] nums2 = { 2,5,6 };
        int n = 3;

        solution_merge86.mergeByMerge(nums1, m, nums2, n);
        solution_merge86.mergeByTwoPointer(nums1, m, nums2, n);
        solution_merge86.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
