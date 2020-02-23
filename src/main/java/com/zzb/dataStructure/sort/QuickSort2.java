package com.zzb.dataStructure.sort;

import com.zzb.dataStructure.BaseUtils;

import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 10:00 2019/4/8
 */
public class QuickSort2 {

    public static void quickSort(int[] arr,int left, int right){
        if(left >= right){
            return;
        }
        int low = left;
        int high = right;
        int target = arr[left];
        while (low < high){
            while (low < high && arr[high] >= target){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= target){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = target;
        quickSort(arr, left, low);
        quickSort(arr, low + 1, right);
    }

    public  static void quickSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = BaseUtils.randomArray(30000, 1, 10);
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.equals(arr,arr));
        System.out.println(Arrays.toString(arr));
    }
}
