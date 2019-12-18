package com.zzb.dataStructure.matrix;

/**
 * @Author by 张志斌 .
 * @Date 10:02 2019/4/17
 * 在排好序的矩阵（N*M）中查找目标值，要求时间复杂度为O(M+N)
 * 思路：使用一个指针从矩阵的右上角开始遍历，指针指向的元素比目标值大就向左，比目标值小就向下
 */
public class SortedMatrix {
    public boolean sortedMatrix(int[][] matrix, int target){
        if(matrix.length == 0){
            return false;
        }
        int pointA = 0;
        int pointB = matrix[0].length - 1;
        while (pointA <= matrix.length - 1 && pointB >= 0){
            if(matrix[pointA][pointB] == target){
                return true;
            }else if(matrix[pointA][pointB] > target){
                pointB--;
            }else {
                pointA++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        m[0][0] = 1;
        m[0][1] = 2;
        m[0][2] = 3;
        m[1][0] = 3;
        m[1][1] = 4;
        m[1][2] = 5;
        m[2][0] = 4;
        m[2][1] = 6;
        m[2][2] = 8;
        SortedMatrix sortedMatrix = new SortedMatrix();
        System.out.println(sortedMatrix.sortedMatrix(m,2));
    }
}
