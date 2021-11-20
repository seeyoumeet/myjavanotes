package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Solution_hasCycle141
 * @Description ：...
 * @Date ：2021-08-30
 * @Created by seeyoumeet
 */
public class Solution_hasCycle141 extends ListNode {

    // 通过哈希表
    public boolean hasCycleBySet(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {      // 如果链表存在环状，指针后移的过程中一定会出现重复的节点
            if (!seen.add(head)) {  // 向Set中添加Head失败
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 通过快慢指针
    public boolean hasCycleByFastSlowPointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {      // 正常的线性链表遍历结束后快慢指针的位置肯定刚好相差2倍
            if (fast == null || fast.next == null) {    // 环状链表遍历时不存在链表尾部一些，fast会一直在环形里兜圈，然后与slow汇合
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_hasCycle141 solution_hasCycle141 = new Solution_hasCycle141();

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(7, l1);
        ListNode l3 = new ListNode(13, l2);
        ListNode l4 = new ListNode(7, l3);
        l1.next = l3;

        System.out.println("链表中" + (solution_hasCycle141.hasCycleBySet(l4) ? "存在" : "不存在") + "环形");
        System.out.println("链表中" + (solution_hasCycle141.hasCycleByFastSlowPointer(l4) ? "存在" : "不存在") + "环形");
    }
}
