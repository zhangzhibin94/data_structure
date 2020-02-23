package com.zzb.dataStructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 14:43 2019/3/26
 */
public class InsertSort {
    public static void insertSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            int target = arr[i];
            int j = i;
            while(j>0 && target < arr[j - 1]){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] =target;
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[15];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Math.abs(random.nextInt()/10000000);
        }
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
