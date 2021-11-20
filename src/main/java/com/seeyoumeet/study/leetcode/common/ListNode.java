package com.seeyoumeet.study.leetcode.common;

/**
 * @Classname ListNode
 * @Description ：...
 * @Date ：2021-09-05
 * @Created by seeyoumeet
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
