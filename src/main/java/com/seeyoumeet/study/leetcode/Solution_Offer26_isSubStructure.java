package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.TreeNode;

/**
 * @Classname Solution_Offer26_isSubStructure
 * @Description ：...
 * @Date ：2021-10-05
 * @Created by seeyoumeet
 */
public class Solution_Offer26_isSubStructure extends TreeNode {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /**
         * 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接：
         * + 以 节点 A 为根节点的子树 包含树 B
         * + 树 B 是 树 A 左子树 的子结构
         * + 树 B 是 树 A 右子树 的子结构
         */
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;          // 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点）
        // 当节点 A 和 B 的值不同：说明匹配失败
        if(A == null || A.val != B.val) return false;   // 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败

        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        Solution_Offer26_isSubStructure solution_offer26_isSubStructure = new Solution_Offer26_isSubStructure();

        TreeNode root1 = new TreeNode(3, new TreeNode(5), new TreeNode(4 , new TreeNode(1), new TreeNode(2)));

        TreeNode root2 = new TreeNode(4, new TreeNode(1));
        boolean isSub = solution_offer26_isSubStructure.isSubStructure(root1, root2);
        System.out.println("root2" + (isSub ? "是" : "不是") + "root1的子结构");
    }
}
