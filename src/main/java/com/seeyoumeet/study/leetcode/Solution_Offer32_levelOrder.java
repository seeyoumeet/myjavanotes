package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname Solution_Offer32_levelOrder
 * @Description ：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 * @Date ：2021-10-01
 * @Created by seeyoumeet
 */
public class Solution_Offer32_levelOrder extends TreeNode {

    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    public static void main(String[] args) {
        Solution_Offer32_levelOrder solution_offer32_levelOrder = new Solution_Offer32_levelOrder();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);
        int[] ret = solution_offer32_levelOrder.levelOrder(root);
        System.out.println(Arrays.asList(ret));
    }
}
