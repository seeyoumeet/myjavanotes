package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;
import com.seeyoumeet.study.leetcode.utils.ListNodeOperation;

/**
 * @Classname Solution_reverseList206
 * @Description ：...
 * @Date ：2021-08-27
 * @Created by seeyoumeet
 */
public class Solution_reverseList206 extends ListNode {

    // 使用迭代
    public ListNode reverseListByIterator(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;       // 翻转方向
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    // 使用递归
    public ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] arg) {
        Solution_reverseList206 solution_reverseList206 = new Solution_reverseList206();

        ListNode ln1 = new ListNode(13);
        ListNode ln2 = new ListNode(5, ln1);
        ListNode ln3 = new ListNode(8, ln2);

        ListNode ln = new ListNode(12, ln3);
        ListNodeOperation.printListNode(solution_reverseList206.reverseListByIterator(ln));
        ListNodeOperation.printListNode(solution_reverseList206.reverseListByRecursive(ln));
    }
}
