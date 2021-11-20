package com.seeyoumeet.study.leetcode;

import com.seeyoumeet.study.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution_isPalindromeListNode234
 * @Description ：给你一个单链表的头节点 head ，请你判断该链表是否为回文链表
 * @Date ：2021-08-28
 * @Created by seeyoumeet
 */
public class Solution_isPalindromeListNode234 extends ListNode {

    // 将链表转换为数组，问题转换为判断是否为回文数组
    public boolean isPalindromeByArray(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文数组
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }

        return true;
    }

    // 使用递归
    private ListNode frontPointer;
    public boolean isPalindromeByRecursive(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {  // 使用递归从listnode从后往前依次将val与frontPointer比对
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;           // 右移frontPointer=
        }
        return true;
    }

    // 使用快慢指针
    public boolean isPalindromeByFastSlowPoint(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文（将链表按中间节点截成两段，翻转后半段后看这两段链表是否完全相等）
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {  // 这里可以以基数节点的1,5,7,9,13,7,5,1和偶数节点数的链表1,5,7,7,5,1来进行模拟
            if (p1.val != p2.val) {     // 这相当于与等索引比较，所以同一个位置下只要有一个值不匹配，就判定不是回文
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;  // 首先拿到curr.next的指针，以免curr断开连接后找不到
            curr.next = prev;               // 再让curr倒过去连接prev
            prev = curr;                    // 右移prev
            curr = nextTemp;                // 右移curr
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {   // 可以尝试用 1,3,7,9,13,9,7,5,1 这串数字进行模拟
            fast = fast.next.next;      // 由于快慢指针的特性（fast走完整个链表时，slow只走过一半），所以可以使用slow很容易的找到链表的中间节点
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution_isPalindromeListNode234 solution_isPalindromeListNode234 = new Solution_isPalindromeListNode234();

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(7, l1);
        ListNode l3 = new ListNode(13, l2);
        ListNode l4 = new ListNode(7, l3);

        ListNode l = new ListNode(5, l4);
        System.out.println("链表 l " + (solution_isPalindromeListNode234.isPalindromeByArray(l) ? "是" : "不是") + "回文链表");
        System.out.println("链表 l " + (solution_isPalindromeListNode234.isPalindromeByRecursive(l) ? "是" : "不是") + "回文链表");
        System.out.println("链表 l " + (solution_isPalindromeListNode234.isPalindromeByFastSlowPoint(l) ? "是" : "不是") + "回文链表");
    }
}
