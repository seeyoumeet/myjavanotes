package com.seeyoumeet.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution_Offer59_MaxQueue
 * @Description ：定义一个队列并实现函数 max_value 得到队列里的最大值
 * @Date ：2021-09-26
 * @Created by seeyoumeet
 */
public class Solution_Offer59_MaxQueue {

    // 维护一个单调的双端队列
    Queue<Integer> q;
    Deque<Integer> d;

    public Solution_Offer59_MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }

        return d.peekFirst();       // 弹出队列首部
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {      // d中的First始终存储的是当前q队列中的最大值
            d.pollLast();
        }

        d.offerLast(value);         // push的时候同时往d和q中插值
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }

        int ans = q.poll();
        if (ans == d.peekFirst()) {     // 如果此时pop的是最大值，则将该值同时也从d中删除
            d.pollFirst();
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_Offer59_MaxQueue solution_offer59_maxQueue = new Solution_Offer59_MaxQueue();
        solution_offer59_maxQueue.push_back(3);
        solution_offer59_maxQueue.push_back(2);
        solution_offer59_maxQueue.push_back(4);
        solution_offer59_maxQueue.push_back(7);
        solution_offer59_maxQueue.push_back(2);

        solution_offer59_maxQueue.pop_front();
        int max = solution_offer59_maxQueue.max_value();
        System.out.println("此时队列中的最大值是：" + max);
    }
}
