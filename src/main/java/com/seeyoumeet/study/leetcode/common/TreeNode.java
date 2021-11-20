package com.seeyoumeet.study.leetcode.common;

/**
 * @Classname TreeNote
 * @Description ：...
 * @Date ：2021-09-05
 * @Created by seeyoumeet
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
