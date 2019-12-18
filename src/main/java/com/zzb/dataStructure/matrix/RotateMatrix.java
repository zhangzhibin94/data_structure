package com.zzb.dataStructure.matrix;

import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 17:16 2019/4/15
 * 旋转打印矩阵
 */
public class RotateMatrix {
    public void printRotateMatrix(int[][] m,int leftA, int leftB, int rightC, int rightD){
        //横向指针,表示列
        int L = leftA;
        //纵向指针
        int R = leftB;
        //如果是同一行
        if(leftA == rightC){
            for(int i = leftB; i <= rightD; i++){
                System.out.println(m[leftA][i]+",");
            }
        }else if(leftB == rightD){
            for(int i = leftA; i <= rightC; i++){
                System.out.println(m[i][leftB]+",");
            }
        }else{
            while (L != rightC){
                System.out.println(m[leftA][L++]);
            }
            while (R != rightD){
                System.out.println(m[R++][rightD]);
            }
            while (L != leftB){
                System.out.println(m[rightC][L--]);
            }
            while (R != leftA){
                System.out.println(m[R--][leftB]);
            }
        }

    }
    public void printRotateMatrix(int[][] m){
        int A = 0;
        int B = 0;
        int C = m.length - 1;
        int D = m[0].length - 1;
        while (A <= C && B <= D){
            printRotateMatrix(m,A++,B++,C--,D--);
        }
    }



    /**
     * 旋转矩阵90°
     * @param m
     * @param A
     * @param B
     * @param C
     * @param D
     */
    public void rotateMatrix(int[][] m, int A, int B, int C, int D){
        for(int i = 0; i < D - B; i++){
            int temp = m[A][B+i];
            m[A][B+i] = m[C - i][B];
            m[C - i][B] = m[C][D - i];
            m[C][D - i] = m[A+i][D];
            m[A+i][D] = temp;
        }
    }

    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();
        int[][] arr= new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;
        r.rotateMatrix(arr,0,0, arr.length - 1, arr[0].length - 1);
        r.printRotateMatrix(arr);
        Arrays.toString(arr);
    }
}
