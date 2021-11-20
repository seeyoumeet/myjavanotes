package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution_Offer68_lowestCommonAncestor
 * @Description ：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 * @Date ：2021-10-03
 * @Created by seeyoumeet
 */
public class Solution_Offer68_lowestCommonAncestor extends TreeNode {

    // 方法一：两次遍历
    public TreeNode lowestCommonAncestorByIterTwo(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;

        // p 和 q 的最近公共祖先就是从根节点到它们路径上的「分岔点」，也就是最后一个相同的节点。
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);       // 从上向下扫描，一直到分叉点
            } else {
                break;      // 从不等于开始，上一轮算出来的ancestor就是最近的公共祖先节点了
            }
        }

        return ancestor;
    }

    // 得到某个节点到目标节点之间的路径节点
    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        path.add(node);

        return path;
    }

    // 方法二：一次遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;      // 如果此时p和q并不同时分布在ancestor的左边或右边（而是ancestor作为分叉点分隔了p、q），则这个ancestor就是最近的公共祖先节点
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        Solution_Offer68_lowestCommonAncestor solution_offer68_lowestCommonAncestor = new Solution_Offer68_lowestCommonAncestor();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);
        TreeNode ancestor = solution_offer68_lowestCommonAncestor.lowestCommonAncestorByIterTwo(root, treeNode2_left, treeNode3_right1);
        System.out.println(ancestor.val);
    }
}
