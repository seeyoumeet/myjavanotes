package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;
import com.seeyoumeet.study.leetcode.utils.TreeNodeOperation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution_isValidBST98
 * @Description ：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树
 * @Date ：2021-09-11
 * @Created by seeyoumeet
 */
public class Solution_isValidBST98 extends TreeNode {

    // 使用递归
    public boolean isValidBSTByRecursive(TreeNode root) {
        return isValidBSTByRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTByRecursive(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        // node.val 的值不在(lower, upper) 区间内
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        // 左右子树任一节点不满足条件即返回false，左子树的值要小于根节点，右子树的值要大于根节点
        return isValidBSTByRecursive(node.left, lower, node.val) && isValidBSTByRecursive(node.right, node.val, upper);
    }

    // 使用中序遍历
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_isValidBST98 solution_isValidBST98 = new Solution_isValidBST98();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);

        TreeNodeOperation.showTree(root);

        System.out.println(solution_isValidBST98.isValidBSTByRecursive(root));
        System.out.println(solution_isValidBST98.isValidBST(root));
    }
}
