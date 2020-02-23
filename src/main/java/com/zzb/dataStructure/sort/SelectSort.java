package com.zzb.dataStructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 15:44 2019/3/26
 */
public class SelectSort {
    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i + 1; j <arr.length; j++){
                if(arr[j] < arr[min]){
                   min = j;
                }
            }
            //交换两个元素
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[15];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Math.abs(random.nextInt()/10000000);
        }
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
