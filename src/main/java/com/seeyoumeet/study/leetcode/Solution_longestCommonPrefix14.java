package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_longestCommonPrefix14
 * @Description ：...
 * @Date ：2021-08-24
 * @Created by seeyoumeet
 */
public class Solution_longestCommonPrefix14 {

    // 使用二分查找
    public String longestCommonPrefixByBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());      // 字符串数组中最短字符串的长度，最长公共前缀的长度一定<=这个长度
        }
        int low = 0, high = minLength;
        while (low < high) {        // low == high时停止，此时已经得到准确的最长公共子串的长度值，即low的值
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefixBaseBinarySearch(strs, mid)) {
                low = mid;          // 如果[0,mid范围内就已经找到了公共前缀，说明那么这个前缀的长度就等于mid，要么可能比mid还大，再从字符串靠右边开始找
            } else {
                high = mid - 1;     // 如果[0, mid]范围内没有找到公共前缀，说明最长公共前缀的长度肯定小于mid，从字符串的靠左边重新找
            }
        }
        return strs[0].substring(0, low);   // 因为isCommonPrefixBaseBinarySearch()是以数组中的第一个字符串做比较的，所以这里写str[0]比较好，但不强求
    }

    public boolean isCommonPrefixBaseBinarySearch(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 使用纵向扫描
    public String longestCommonPrefixByVerticalScan(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();      // 数组中第一个字符串的长度
        int count = strs.length;            // 字符串数组的长度
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);     // 对str[0]中的每个字符，将它拿出来与数组中其他所有字符串相同位置的字符做比较
            for (int j = 1; j < count; j++) {   // 比较过程中如果有某个字符串指定位置上的字符不匹配，说明[0, i-1]就是最长公共前缀的长度
                if (i == strs[j].length() || strs[j].charAt(i) != c) {  // 由于str[0]是长度没有指定为数组中最短的字符串，所以可能出现之后遍历过程中遇到比它短的字符串
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // 使用横向扫描
    public String longestCommonPrefixByHorizontalScan(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefixByHorizontalScan(prefix, strs[i]);  // prefix 表示数组中两个字符串之间的公共前缀
            if (prefix.length() == 0) {     // 如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefixByHorizontalScan(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());    // 最长公共前缀的长度一定小于或等于较短的字符串长度
        int index = 0;      // 对两个字符串[0, length]范围内的字符挨个作比较，最终得到的index就是这俩字符串之间的最长公共前缀的长度
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    // 使用分治算法
    public String longestCommonPrefixByDivide(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefixByDivide(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefixByDivide(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;        // 将在[start, end]范围内找出最长公共前缀的问题分解为在[start, mid]范围和[mid+1, end]范围内找出最长公共前缀这两个子问题
            String lcpLeft = longestCommonPrefixByDivide(strs, start, mid);           // 左边范围得到的最长公共前缀字符串
            String lcpRight = longestCommonPrefixByDivide(strs, mid + 1, end);  // 右边范围得到的最长公共前缀字符串
            return commonPrefixByDivide(lcpLeft, lcpRight);
        }
    }

    public String commonPrefixByDivide(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());

        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {  // 取出两个字符串之间的最长公共前缀
                return lcpLeft.substring(0, i);
            }
        }

        return lcpLeft.substring(0, minLength);
    }

    public static void main(String[] args) {
        Solution_longestCommonPrefix14 solution_longestCommonPrefix14 = new Solution_longestCommonPrefix14();

        String[] strs = {"flower", "flow", "flight"};
        String longestPre = solution_longestCommonPrefix14.longestCommonPrefixByBinarySearch(strs);
        System.out.println("strs的最长公共子串是：" + longestPre + "(二分查找)");

        String longestPre2 = solution_longestCommonPrefix14.longestCommonPrefixByVerticalScan(strs);
        System.out.println("strs的最长公共子串是：" + longestPre2 + "(纵向扫描)");

        String longestPre3 = solution_longestCommonPrefix14.longestCommonPrefixByHorizontalScan(strs);
        System.out.println("strs的最长公共子串是：" + longestPre3 + "(横向扫描)");

        String longestPre4 = solution_longestCommonPrefix14.longestCommonPrefixByDivide(strs);
        System.out.println("strs的最长公共子串是：" + longestPre4 + "(分治解决)");
    }
}
