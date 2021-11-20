package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;
import com.seeyoumeet.study.leetcode.utils.ListNodeOperation;

/**
 * @Classname Solution_mergeTwoLists21
 * @Description ：将两个升序链表合并为一个新的 升序 链表并返回
 * @Date ：2021-08-26
 * @Created by seeyoumeet
 */
public class Solution_mergeTwoLists21 extends ListNode {

    // 使用递归
    public ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 从小到大按照listNode值连接两个链表的结点
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsByIterator(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        Solution_mergeTwoLists21 solution_mergeTwoLists21 = new Solution_mergeTwoLists21();

        // 保证有序
        ListNode tmp_Node = new ListNode(7);
        ListNode l1 = new ListNode(5, tmp_Node);

        ListNode tmp_Node2 = new ListNode(13);
        ListNode tmp_Node3 = new ListNode(9, tmp_Node2);
        ListNode l2 = new ListNode(6, tmp_Node3);

        ListNodeOperation.printListNode(solution_mergeTwoLists21.mergeTwoListsByRecursion(l1, l2));
        ListNodeOperation.printListNode(solution_mergeTwoLists21.mergeTwoListsByIterator(l1, l2));
    }
}
