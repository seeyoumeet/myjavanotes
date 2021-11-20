package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;
import com.seeyoumeet.study.leetcode.utils.ListNodeOperation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution_removeNthFromEnd19
 * @Description ：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * @Date ：2021-08-29
 * @Created by seeyoumeet
 */
public class Solution_removeNthFromEnd19 extends ListNode{

    // 通过计算链表长度
    public ListNode removeNthFromEndByLength(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {  // i 的最大值是 length-n
            cur = cur.next;
        }
        cur.next = cur.next.next;   // 从链表中删除cur.next
        ListNode ans = dummy.next;  // dummy 一直指向的是链表的head
        return ans;
    }

    // 得到链表长度
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    // 使用栈
    public ListNode removeNthFromEndByStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {   // 把链表中所有值装到栈中
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {   // 弹出栈顶n位的元素
            stack.pop();
        }
        ListNode prev = stack.peek();   // 取得当前栈顶部的节点
        prev.next = prev.next.next;     // 删除perv.next指向的节点
        ListNode ans = dummy.next;
        return ans;
    }

    // 使用双指针
    public ListNode removeNthFromEndByTwoPointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {   // first 向后移动 n 次（要删节点的前一个节点）
            first = first.next;
        }
        while (first != null) {     // 不是first.next != null 而是 first != null
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        Solution_removeNthFromEnd19 solution_removeNthFromEnd19 = new Solution_removeNthFromEnd19();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(7, l1);
        ListNode l3 = new ListNode(13, l2);
        ListNode l4 = new ListNode(7, l3);

        ListNode l = new ListNode(5, l4);
//        printListNode(solution_removeNthFromEnd19.removeNthFromEndByLength(l, 2));
//        printListNode(solution_removeNthFromEnd19.removeNthFromEndByStack(l, 2));
        ListNodeOperation.printListNode(solution_removeNthFromEnd19.removeNthFromEndByTwoPointer(l, 2));
    }
}
