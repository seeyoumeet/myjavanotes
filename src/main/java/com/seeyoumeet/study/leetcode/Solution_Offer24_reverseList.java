package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;

/**
 * @Classname Solution_Offer24_reverseList
 * @Description ：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 * @Date ：2021-09-24
 * @Created by seeyoumeet
 */
public class Solution_Offer24_reverseList extends ListNode {

    // 方法一：迭代
    public ListNode reverseListByIter(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 方法二：递归
    public ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution_Offer24_reverseList solution_offer24_reverseList = new Solution_Offer24_reverseList();

        ListNode ln1 = new ListNode(13);
        ListNode ln2 = new ListNode(5, ln1);
        ListNode ln3 = new ListNode(8, ln2);

        ListNode ln = new ListNode(12, ln3);
        solution_offer24_reverseList.reverseListByIter(ln);
    }
}
