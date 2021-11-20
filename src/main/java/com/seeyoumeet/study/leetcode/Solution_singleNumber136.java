package com.seeyoumeet.study.leetcode;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Solution_singleNumber136
 * @Description ：...
 * @Date ：2021-08-18
 * @Created by seeyoumeet
 */
public class Solution_singleNumber136 {
    public int singleNumberBySet(int[] nums) {
        Set set = new HashSet();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);        // 最后仍在set中的是出现次数为基数个的
            }
        }

        Integer[] myArray = new Integer[set.size()];
        set.toArray(myArray);

        return myArray[0];
    }

    public int singleNumberByMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer count;
        for (int num : nums) {      // 对每个数字记录出现的次数并更新到map中
            count = map.get(num);
            map.put(num, count == null ? 1 : ++count);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_singleNumber136 ss = new Solution_singleNumber136();
        int[] nums = {1, 2, 2, 1, 4, 5, 7, 4, 5};
        int single_num = ss.singleNumberBySet(nums);
        System.out.println(single_num);

        int single_num2 = ss.singleNumberByMap(nums);
        System.out.println(single_num2);
    }
}
