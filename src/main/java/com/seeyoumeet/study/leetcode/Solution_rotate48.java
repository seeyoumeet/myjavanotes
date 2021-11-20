package com.seeyoumeet.study.leetcode;

/**
 * @Classname Solution_rotate48
 * @Description ：...
 * @Date ：2021-09-01
 * @Created by seeyoumeet
 */
public class Solution_rotate48 {

    // 使用辅助数组(由于使用了辅助数组，所以有了额外的空间复杂度）
    public void rotateByNewArr(int[][] matrix) {
        int n = matrix.length;                  // 旋转之前的数组
        int[][] matrix_new = new int[n][n];     // 旋转之后的数组

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // 对于矩阵中第i行第j列的元素，在旋转后，它将出现在倒数第 i 列的第 j 个位置
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];    // copy 数组以实现原地旋转
            }
        }
    }

    // 原地旋转（基于方法一推导的公式）
    public void rotateByInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {       // 由于数字会将整个数组修正，对上半部分的遍历实际上已经更正了下半部分的位置（无需对每个元素都用交换处理）
            for (int j = 0; j < (n + 1) / 2; ++j) {
                // 顺时针旋转，由于没有辅助数组，原地旋转的话需要一次性将(i,j)旋转过程中影响的元素的值全部更正
                /**
                 *  5   1   9  11
                 *  2   4   8  10
                 * 13   3   6   7
                 * 15  14  12  16
                 * 如果此时旋转的是[0,1]即1的位置，则temp==1, 13-->1的位置, 12-->13的位置，10-->12的位置，1-->10的位置
                 */
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    // 用翻转代替旋转
    public void rotateByFlip(int[][] matrix) {
        int n = matrix.length;

        // 按水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // 按主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution_rotate48 solution_rotate48 = new Solution_rotate48();

        int[][] matrix = { {1,2,3},{4,5,6},{7,8,9} };
        solution_rotate48.rotateByNewArr(matrix);
        solution_rotate48.rotateByInPlace(matrix);
        solution_rotate48.rotateByFlip(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) {
                    System.out.print(matrix[i][j]);
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
}
