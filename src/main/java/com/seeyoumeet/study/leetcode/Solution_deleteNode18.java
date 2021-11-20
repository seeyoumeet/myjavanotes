package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;
import com.seeyoumeet.study.leetcode.utils.ListNodeOperation;

/**
 * @Classname Solution_deleteNode18
 * @Description ：...
 * @Date ：2021-08-30
 * @Created by seeyoumeet
 */
public class Solution_deleteNode18 extends ListNode {

    // 通过双指针
    public ListNode deleteNodeByTwoPointer(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;

        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

    // 通过单指针
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;  // 删除头部节点，更改引用
        ListNode cur = head;

        while (cur.next != null && cur.next.val != val)     // cur 应是待删节点的前一节点
            cur = cur.next;
        if (cur.next != null)       // 说明上面循环因为cur.next.val == val条件退出了
            cur.next = cur.next.next;   // 删除cur.next
        return head;
    }

    public static void main(String[] args) {
        Solution_deleteNode18 solution_deleteNode18 = new Solution_deleteNode18();

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(7, l1);
        ListNode l3 = new ListNode(13, l2);
        ListNode l4 = new ListNode(9, l3);

        ListNode head = new ListNode(6, l4);

        ListNodeOperation.printListNode(solution_deleteNode18.deleteNode(head, 7));
        ListNodeOperation.printListNode(solution_deleteNode18.deleteNodeByTwoPointer(head, 5));
    }
}
