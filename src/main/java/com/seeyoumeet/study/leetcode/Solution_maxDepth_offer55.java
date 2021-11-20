package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution_maxDepth_offer55
 * @Description ：
 *
 * 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历
     * 常见的 BFS ： 层序遍历（即按层遍历）
 * @Date ：2021-09-04
 * @Created by seeyoumeet
 */
public class Solution_maxDepth_offer55 extends TreeNode {

    // 后续遍历
    public int maxDepthByDFS(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepthByDFS(root.left), maxDepthByDFS(root.right)) + 1;
    }

    // 层序遍历（BFS）
    public int maxDepthByBFS(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(5, new TreeNode(), new TreeNode(6, new TreeNode(), new TreeNode()));
        TreeNode right1 = new TreeNode(9, new TreeNode(8, new TreeNode(10, new TreeNode(), new TreeNode()), new TreeNode()), new TreeNode());

        TreeNode treeNode1 = new TreeNode(7, left1, right1);

        Solution_maxDepth_offer55 solution_maxDepth_offer55 = new Solution_maxDepth_offer55();
        System.out.println("TreeNote1 的最大深度" + solution_maxDepth_offer55.maxDepthByDFS(treeNode1));
        System.out.println("TreeNote1 的最大深度" + solution_maxDepth_offer55.maxDepthByBFS(treeNode1));
    }
}
