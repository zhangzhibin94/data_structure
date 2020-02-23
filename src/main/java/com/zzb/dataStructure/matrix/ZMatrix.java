package com.zzb.dataStructure.matrix;

import com.zzb.dataStructure.BaseUtils;

/**
 * @Author by 张志斌 .
 * @Date 10:25 2019/4/16
 * Z字形打印矩阵
 */
public class ZMatrix {
    public static void ZPrintMatrix(int[][] m){
        //标志位 从上到下打印(true)还是从下到上打印(false)
        boolean flag = false;
        //横向指针坐标A
        int APoint = 0;
        //横向指针坐标B
        int BPoint = 0;
        //纵向指针坐标C
        int CPoint = 0;
        //纵向指针坐标D
        int DPoint = 0;
        System.out.println(m[0][0]);
        while(APoint <= CPoint && BPoint >= DPoint){

            //如果遍历到了数组末尾，指针向下
            if(BPoint == m[0].length - 1){
                APoint++;
            }else{
                BPoint++;
            }
            if(CPoint ==  m.length - 1){
                DPoint++;
            }else {
                CPoint++;
            }
            //打印（A,B）到(C,D)之间的数
            print(m,APoint,BPoint,CPoint,DPoint,flag);
            flag = !flag;
        }
    }

    /**
     * 打印（A,B）位置到（C,D）位置的元素
     * @param m
     * @param A
     * @param B
     * @param C
     * @param D
     * @param flag
     */
    public static void print(int[][] m, int A, int B, int C, int D,boolean flag){
        if(flag){
            while(A != C + 1){
                System.out.println(m[A++][B--]);
            }
        }else{
            while (A != C + 1){
                System.out.println(m[C--][D++]);
            }
        }
    }


    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();
        /*int[][] arr= new int[4][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;
        arr[3][0] = 10;
        arr[3][1] = 11;
        arr[3][2] = 12;*/
        int[][] arr = BaseUtils.randomMatrix(3, 3);
        BaseUtils.printMatrix(arr);
        ZPrintMatrix(arr);

    }
}
