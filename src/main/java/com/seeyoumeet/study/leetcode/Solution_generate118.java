package com.seeyoumeet.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution_generate118
 * @Description ：给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行
 * @Date ：2021-09-15
 * @Created by seeyoumeet
 */
public class Solution_generate118 {

    // 按照数学公式计算前numRows行的数字
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution_generate118 solution_generate118 = new Solution_generate118();

        int numRows = 5;
        List<List<Integer>> triangle = solution_generate118.generate(numRows);
    }
}
