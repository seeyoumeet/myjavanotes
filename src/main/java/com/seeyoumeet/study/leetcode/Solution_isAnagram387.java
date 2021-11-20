package com.seeyoumeet.study.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Classname Solution_isAnagram387
 * @Description ：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引
 * @Date ：2021-08-25
 * @Created by seeyoumeet
 */
public class Solution_isAnagram387 {

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

    // 使用队列
    public int firstUniqCharByQueue(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();

        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {   // 检查头部元素是否是非重复字符
                    queue.poll();       // 保证队列头部一定是非重复字符（由于队列先进先出的特性，头部的pos一定更小）
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;     // 如果队列最后为空则表示不存在这个值，否则取出此时队列头部中的pos
    }

    // 使用哈希表存储频数，记录每个字符在字符串中出现的频数
    public int firstUniqCharByMapChar(String s) {

        // 使用哈希表存储频数，记录每个字符在字符串中出现的频数
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {      // 第一次遍历字符串，得到所有字符出现的频数并存在哈希表里
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); ++i) {      // 第二次遍历字符串，一旦字符的频数等于1（不重复），就返回它的索引
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // 使用哈希表记录每个字符第一次出现的索引
    public int firstUniqCharByMapPos(String s) {
        // 记录每个字符第一次出现的索引
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);   // 如果不是第一次出现，则写入ch - > -1
            } else {
                position.put(ch, i);        // 以leetcode为例，则记录的是0,1,-1,3,4,5,6,-1
            }
        }

        int first = n;      // 不重复字符第一次出现的位置
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {     // 从索引表中取出不重复字符第一次出现的索引集合并从中找到最小值赋给first
                first = pos;        // 如果pos全部是-1时，+first也为-1，此时字符串不存在不重复字符
            }
        }

        if (first == n) {
            first = -1;
        }

        return first;
    }

    public static void main(String[] args) {
        Solution_isAnagram387 solution_isAnagram387 = new Solution_isAnagram387();

        String s = "leetcode";
        int first = solution_isAnagram387.firstUniqCharByQueue(s);
        System.out.println(s + "中第一个不重复的字符在" + first + "的位置");

        first = solution_isAnagram387.firstUniqCharByMapChar(s);
        System.out.println(s + "中第一个不重复的字符在" + first + "的位置");

        first = solution_isAnagram387.firstUniqCharByMapPos(s);
        System.out.println(s + "中第一个不重复的字符在" + first + "的位置");
    }
}
