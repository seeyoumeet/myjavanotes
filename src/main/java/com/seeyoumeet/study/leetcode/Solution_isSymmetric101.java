package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.utils.TreeNodeOperation;
import com.seeyoumeet.study.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution_isSymmetric101
 * @Description ：...
 * @Date ：2021-09-05
 * @Created by seeyoumeet
 */
public class Solution_isSymmetric101 extends TreeNode {

    // 1. 使用递归
    public boolean isSymmetricByRecursive(TreeNode root) {
        return checkByRecursive(root, root);
    }

    // 检查左右子树的深度和值是否相等
    public boolean checkByRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {   // 同时满足null
            return true;
        }

        // 有一个指针不满足null
        if (p == null || q == null) {
            return false;
        }

        // p、q都不为null的情况下，p和q的值也同时相等
        return p.val == q.val && checkByRecursive(p.left, q.right) && checkByRecursive(p.right, q.left);
    }

    // 2. 使用迭代(把递归程序改写成迭代程序)
    public boolean isSymmetricByIterator(TreeNode root) {
        return checkByIterator(root, root);
    }


    public boolean checkByIterator(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }

            // 有一个先为null或者存在两边的值不等时直接返回false
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            // 由于判断的是镜像对称，所以左边的left要与右边的rght比较，左边的right要与右边的left比较
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_isSymmetric101 solution_isSymmetric101 = new Solution_isSymmetric101();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);

        // 将刚刚创建的树打印出来
        System.out.println("TreeNote 结构如下：");
        TreeNodeOperation.showTree(root);

        System.out.println("TreeNode " + (solution_isSymmetric101.isSymmetricByRecursive(root) ? "是" : "不是") + "对称树");
        System.out.println("TreeNode " +  (solution_isSymmetric101.isSymmetricByIterator(root) ? "是" : "不是") + "对称树");
    }
}
