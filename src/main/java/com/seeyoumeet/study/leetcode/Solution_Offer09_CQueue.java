package com.seeyoumeet.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution_Offer09_CQueue
 * @Description ：剑指 Offer 09. 用两个栈实现队列
 * @Date ：2021-09-22
 * @Created by seeyoumeet
 */
public class Solution_Offer09_CQueue {

    Deque<Integer> stack1;      // 控制插入元素
    Deque<Integer> stack2;      // 控制删除元素

    public Solution_Offer09_CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    // 在队列尾部插入整数
    public void appendTail(int value) {
        stack1.push(value);
    }

    // 在队列头部删除整数
    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }

    public static void main(String[] args) {
        Solution_Offer09_CQueue solution_offer09_cQueue = new Solution_Offer09_CQueue();
        solution_offer09_cQueue.appendTail(7);
        solution_offer09_cQueue.appendTail(5);
        solution_offer09_cQueue.deleteHead();
    }
}
