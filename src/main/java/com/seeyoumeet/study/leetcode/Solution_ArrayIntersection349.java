package com.seeyoumeet.study.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Solution_ArrayIntersection349
 * @Description ： 题目描述：给定两个数组，编写一个函数来计算它们的交集
 * @Date ：2021-08-07
 * @Created by seeyoumeet
 */
public class Solution_ArrayIntersection349 {
    public int[] ArrayIntersectionBySet(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersectArr(set1, set2);
    }

    public int[] ArrayIntersectionBySort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;
        int[] intersectArr = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;      // index-intersectArr索引，index1-nums1索引，index2-nums2索引

        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersectArr[index - 1]) {
                    intersectArr[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        return Arrays.copyOfRange(intersectArr, 0, index);
    }

    public int[] getIntersectArr(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersectArr(set2, set1);
        }

        Set<Integer> intersectSet = new HashSet<Integer>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectSet.add(num);      // 通过集合Set来判断重复值
            }
        }

        int[] intersection = new int[intersectSet.size()];
        int index = 0;
        for (int num : intersectSet) {
            intersection[index++] = num;
        }

        return intersection;
    }

    public static void main(String[] args) {
        Solution_ArrayIntersection349 ai = new Solution_ArrayIntersection349();
        int[] nums1 = {1, 3, 3, 1};
        int[] nums2 = {3, 3};

        int[] intersect1 = ai.ArrayIntersectionBySet(nums1, nums2);
        System.out.println(Arrays.toString(intersect1));

        int[] intersect2 = ai.ArrayIntersectionBySort(nums1, nums2);
        System.out.println(Arrays.toString(intersect2));
    }
}
