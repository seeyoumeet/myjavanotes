package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;

/**
 * @Classname Solution_Offer37_Codec
 * @Description ：请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * @Date ：2021-10-04
 * @Created by seeyoumeet
 */
public class Solution_Offer27_mirrorTree extends TreeNode {
    // 方法一：递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        Solution_Offer27_mirrorTree solution_offer27_mirrorTree = new Solution_Offer27_mirrorTree();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);
        solution_offer27_mirrorTree.mirrorTree(root);
    }
}
