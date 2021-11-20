package com.seeyoumeet.study.leetcode.utils;

import com.seeyoumeet.study.leetcode.common.ListNode;

/**
 * @Classname ListNodeUtils
 * @Description ：...
 * @Date ：2021-09-05
 * @Created by seeyoumeet
 */
public class ListNodeOperation extends ListNode {
    // 打印 ListNode
    public static void printListNode(ListNode listNode){
        // 创建链表节点
        while(listNode != null){
            System.out.println("节点：" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println("---------------------");
    }
}
