package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;

import java.util.Stack;

/**
 * @Classname Solution_Offer06_reversePrint
 * @Description ：剑指 Offer 06. 从尾到头打印链表
 * @Date ：2021-09-21
 * @Created by seeyoumeet
 */
public class Solution_Offer06_reversePrint {

    // 利用栈的先进后出的特性
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }

        return print;
    }

    public static void main(String[] args) {
        Solution_Offer06_reversePrint solution_offer06_reversePrint = new Solution_Offer06_reversePrint();
        ListNode tmp_Node = new ListNode(7);
        ListNode l1 = new ListNode(5, tmp_Node);

        ListNode tmp_Node2 = new ListNode(13, l1);
        ListNode tmp_Node3 = new ListNode(9, tmp_Node2);
        ListNode l2 = new ListNode(6, tmp_Node3);

        ListNode head = new ListNode(10, l2);

        int[] list_reserve = solution_offer06_reversePrint.reversePrint(head);
        System.out.println("链表的逆序为：");
        for(int i = 0; i < list_reserve.length; i++) {
            if (i == 0) {
                System.out.print(list_reserve[i]);
            } else {
                System.out.print(" " + list_reserve[i]);
            }
        }
    }
}
