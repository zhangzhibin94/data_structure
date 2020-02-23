package com.zzb.dataStructure.matrix;

import com.zzb.dataStructure.BaseUtils;

/**
 * @Author by 张志斌 .
 * @Date 17:29 2019/4/16
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int a = 1;
        int A = 0;
        int B = 0;
        int C = m.length - 1;
        int D = m[0].length - 1;
        while (A <= C && B <= D ) {
            a = generateMatrix(m,A++,B++,C--,D--,a);
        }
        //todo
        return m;
    }

    public int generateMatrix(int[][] m, int A, int B, int C, int D, int a){
        //同一行
        if(A == C){
            for(int i = B; i <= D; i++){
                m[A][i] = a++;
            }
            //同一列
        }else if(B == D){
            for(int i = A; i <= C; i++){
                m[i][B] = a++;
            }
        }else{
            int point1 = A;
            int point2 = B;
            while (point1 < D){
                m[A][point1++] = a++;
            }
            while (point2 < C){
                m[point2++][point1] = a++;
            }
            while (point1 > B){
                m[point2][point1--] = a++;
            }
            while (point2 > A){
                m[point2--][point1] = a++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        GenerateMatrix g = new GenerateMatrix();
        int[][] ints = g.generateMatrix(4);
        BaseUtils.printMatrix(ints);
    }
}
