package com.zzb.dataStructure.sort;

import com.zzb.dataStructure.BaseUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 10:49 2019/3/26
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr,int start, int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int target = arr[start];
        while (left < right){
            while (right < left && arr[right] >= target){
                right--;
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = BaseUtils.randomArray();

        long startTime = System.currentTimeMillis();
        quickSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
