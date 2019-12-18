package com.zzb.dataStructure.matrix;

import com.zzb.dataStructure.BaseUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 14:44 2019/4/16
 * 顺时针旋转矩阵
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int A = 0;
        int B = 0;
        int C = matrix.length - 1;
        int D = matrix[0].length - 1;
       /* result.addAll(spiralOne(matrix, A++,B++,C--,D--));*/
        while (A <= C && B <= D){
            result.addAll(spiralOne(matrix, A++,B++,C--,D--));
        }
        return result;
    }

    public List<Integer> spiralOne(int[][] m, int A, int B, int C, int D){
        List<Integer> result = new ArrayList<>();
        //只有一行
        if(A == C){
            //遍历列
            for(int i = B ;i <= D; i++){
                result.add(m[A][i]);
            }
            //只有一列
        }else if(B == D){
            for(int i = A ;i <= C; i++){
                result.add(m[i][B]);
            }
        }else{
            int point1 = A;
            int point2 = B;
            while (point1 < D){
                result.add(m[A][point1++]);
            }
            while (point2 < C){
                result.add(m[point2++][point1]);
            }

            while (point1 > B){
                result.add(m[point2][point1--]);
            }
            while (point2 > A){
                result.add(m[point2--][point1]);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] m = BaseUtils.randomMatrix(4, 4);
        BaseUtils.printMatrix(m);
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> integers = spiralOrder.spiralOrder(m);
        System.out.println(integers);
    }
}
