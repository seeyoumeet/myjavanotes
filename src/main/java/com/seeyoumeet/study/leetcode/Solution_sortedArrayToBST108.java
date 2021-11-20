package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;
import com.seeyoumeet.study.leetcode.utils.TreeNodeOperation;

import java.util.Random;

/**
 * @Classname Solution_sortedArrayToBST108
 * @Description ：给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树
 * @Date ：2021-09-06
 * @Created by seeyoumeet
 */
public class Solution_sortedArrayToBST108 extends TreeNode {

    // 使用中序遍历
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // 总是选择中间位置左边的数字作为根节点
    public TreeNode leftHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);    // 向root的left和right上添加子节点
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    // 总是选择中间位置右边的数字作为根节点
    public TreeNode rightHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    Random rand = new Random();
    // 选择任意一个中间位置数字作为根节点
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution_sortedArrayToBST108 solution_sortedArrayToBST108 = new Solution_sortedArrayToBST108();

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = solution_sortedArrayToBST108.sortedArrayToBST(nums);

        TreeNodeOperation.showTree(treeNode);
    }
}
