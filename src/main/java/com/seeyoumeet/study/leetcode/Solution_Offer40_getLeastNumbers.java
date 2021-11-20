package com.seeyoumeet.study.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Classname Solution_Offer40_getLeastNumbers
 * @Description ：输入整数数组 arr ，找出其中最小的 k 个数
 * @Date ：2021-10-06
 * @Created by seeyoumeet
 */
public class Solution_Offer40_getLeastNumbers {

    // 方法一：排序
    public int[] getLeastNumbersBySort(int[] arr, int k) {
        int[] vec = new int[k];

        Arrays.sort(arr);       // 从小到大排序
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];    // 取出数组前k位数
        }

        return vec;
    }

    // 方法二：堆
    public int[] getLeastNumbersByHeap(int[] arr, int k) {
        int[] vec = new int[k];

        if (k == 0) {   // 排除 0 的情况
            return vec;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);        // 数组中[0, k-1]位的数先放到队列中
        }

        for (int i = k; i < arr.length; ++i) {  // 如果队列中的数比后[k, arr.length-1]内的数大。则取出队列头部元素，放新的小元素进去
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }

        return vec;
    }

    // 方法三：快排思想
    public int[] getLeastNumbersByQuickSort(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);

        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }

        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }

        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;

        Solution_Offer40_getLeastNumbers solution_offer40_getLeastNumbers = new Solution_Offer40_getLeastNumbers();
        solution_offer40_getLeastNumbers.getLeastNumbersBySort(arr, k);
    }
}
