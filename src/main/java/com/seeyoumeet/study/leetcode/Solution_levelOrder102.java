package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;
import com.seeyoumeet.study.leetcode.utils.TreeNodeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution_levelOrder102
 * @Description ：二叉树的层序遍历
 * @Date ：2021-09-10
 * @Created by seeyoumeet
 */
public class Solution_levelOrder102 extends TreeNode {

    // 使用广度优先搜索
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();     // 存储每一层的节点值
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {       // 遍历某一层的所有节点
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {                        // 取出某一层节点的左右子节点推入队列作为下一次的根节点
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public static void main(String[] agrs) {
        Solution_levelOrder102 solution_levelOrder102 = new Solution_levelOrder102();

        TreeNode treeNode3_left1 = new TreeNode(5, new TreeNode(7));
        TreeNode treeNode3_left2 = new TreeNode(4);
        TreeNode treeNode3_right1 = new TreeNode(4);
        TreeNode treeNode3_right2 = new TreeNode(5, null, new TreeNode(7));

        TreeNode treeNode2_left = new TreeNode(13, treeNode3_left1, treeNode3_left2);
        TreeNode treeNode2_right = new TreeNode(13, treeNode3_right1, treeNode3_right2);

        TreeNode root = new TreeNode(7, treeNode2_left, treeNode2_right);

        TreeNodeOperation.showTree(root);

        List<List<Integer>> ret = solution_levelOrder102.levelOrder(root);
        System.out.println(ret);
    }
}
