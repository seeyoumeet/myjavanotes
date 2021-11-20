package com.seeyoumeet.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution_MinStack155
 * @Description ：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 * @Date ：2021-09-17
 * @Created by seeyoumeet
 */
public class Solution_MinStack155 {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public Solution_MinStack155() {
        // 使用辅助栈minStack，与元素栈xStack同时push和pop，每次存储栈中的最小值
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution_MinStack155 solution_minStack155 = new Solution_MinStack155();

        solution_minStack155.push(3);
        solution_minStack155.push(19);
        solution_minStack155.push(-1);
        solution_minStack155.push(7);

        int min = solution_minStack155.getMin();
        System.out.println("栈中的最小值为：" + min);
    }
}
