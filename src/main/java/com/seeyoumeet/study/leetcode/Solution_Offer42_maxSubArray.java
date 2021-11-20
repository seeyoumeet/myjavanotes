package com.seeyoumeet.study.leetcode;

import java.util.Arrays;

/**
 * @Classname Solution_Offer42_maxSubArray
 * @Description ：输入一个整型数组，数组中的一个或连续多个整数组成一个子数组
 * @Date ：2021-09-29
 * @Created by seeyoumeet
 */
public class Solution_Offer42_maxSubArray {

    // 方法一：动态规划
    public int maxSubArrayByDP(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }

        return maxAns;
    }

    // 方法二：分治
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArrayByFZ(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        Solution_Offer42_maxSubArray solution_offer42_maxSubArray = new Solution_Offer42_maxSubArray();
        int maxChildArrSum = solution_offer42_maxSubArray.maxSubArrayByDP(nums);
        System.out.println(Arrays.asList(nums) + " 的最大子数组和为 " + maxChildArrSum);
    }
}
