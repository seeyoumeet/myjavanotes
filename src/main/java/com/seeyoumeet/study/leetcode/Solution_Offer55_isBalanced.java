package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;

/**
 * @Classname Solution_Offer55_isBalanced
 * @Description ：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 * @Date ：2021-10-02
 * @Created by seeyoumeet
 */
public class Solution_Offer55_isBalanced extends TreeNode {

    // 方法一：自顶向下的递归
    public boolean isBalancedToBottom(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(heightToBottom(root.left) - heightToBottom(root.right)) <= 1 && isBalancedToBottom(root.left) && isBalancedToBottom(root.right);
        }
    }

    public int heightToBottom(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(heightToBottom(root.left), heightToBottom(root.right)) + 1;
        }
    }

    // 方法二：自底向上的递归
    public boolean isBalancedToTop(TreeNode root) {
        return heightToTop(root) >= 0;
    }

    public int heightToTop(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightToTop(root.left);
        int rightHeight = heightToTop(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        Solution_Offer55_isBalanced solution_offer55_isBalanced = new Solution_Offer55_isBalanced();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);
        solution_offer55_isBalanced.isBalancedToBottom(root);
    }
}
