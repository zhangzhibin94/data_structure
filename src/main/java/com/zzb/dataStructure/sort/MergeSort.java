package com.zzb.dataStructure.sort;

import com.zzb.dataStructure.BaseUtils;

import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 14:29 2019/4/4
 * 归并排序
 *
 */
public class MergeSort {
    /**
     * 归并排序
     * @param arr
     */
    public static  void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }
    private static  void mergeSort(int[] arr, int left,int right){
        if(right == left){
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid,int right) {
        if(right == left){
            return;
        }
        int low = left;
        int high = mid + 1;
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        while (low <= mid && high <= right){
            if(arr[low] <= arr[high]){
                tempArr[index++] = arr[low++];
            }else{
                tempArr[index++] = arr[high++];
            }
        }
        while (low <= mid){
            tempArr[index++] = arr[low++];
        }
        while (high <= right){
            tempArr[index++] = arr[high++];
        }
        for(int i = 0; i < tempArr.length; i++){
            arr[left + i] = tempArr[i];
        }

    }

    /**
     * 小和：在当前元素左侧并且比当前元素小的数之和
     * 求数组中所有元素的小和。
     * 思路：就是求当前元素在整个求小和过程中一共出现了多少次
     * @param arr
     */
    public static int smallSum(int[] arr){
        if(arr.length == 0 || arr.length == 1){
            return 0;
        }
        return smallSum(arr, 0, arr.length - 1);
    }
    public static int  smallSum(int[] arr, int left, int right){
        if(left == right){
            return 0;
        }
        int mid = (left + right) /2;
        return smallSum(arr, left, mid)
                + smallSum(arr, mid + 1, right)
                + mergeSmallSum(arr, left, mid, right);
    }

    private static int mergeSmallSum(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        int low = left;
        int high = mid + 1;
        int sum = 0;
        while (low <= mid && high <= right){
            if(arr[low] < arr[high]){
                sum += arr[low] * (right - high + 1);
            }
            if(arr[low] <= arr[high]){
                tempArr[index++] = arr[low++];
            }else{
                tempArr[index++] = arr[high++];
            }
        }
        while(low <= mid){
            tempArr[index++] = arr[low++];
        }
        while (high <= right){
            tempArr[index++] = arr[high++];
        }
        for(int i = 0; i < tempArr.length; i++){
            arr[left + i] = tempArr[i];
        }
        return sum;
    }



    public static int mergeSum(int[] arr){
        if(arr.length==0 || arr.length==1){
            return 0;
        }
        return mergeSum(arr,0, arr.length - 1);
    }
    public static int mergeSum(int[] arr, int left, int right){
        if(left == right){
            return 0;
        }
        int mid = (left + right) / 2;
        return mergeSum(arr, left, mid)
                + mergeSum(arr, mid + 1, right)
                + merge2(arr,left, mid, right);
    }

    private static int merge2(int[] arr, int left, int mid, int right) {
        int LPoint = left;
        int RPoint = mid + 1;
        int result = 0;
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        while (LPoint <= mid && RPoint <= right){
            if(arr[LPoint] < arr[RPoint]){
                result += arr[LPoint] * (right - RPoint + 1);
            }
            if(arr[LPoint] < arr[RPoint]){
                tempArr[index++] = arr[LPoint++];
            }else {
                tempArr[index++] = arr[RPoint++];
            }
        }
        while (LPoint <= mid){
            tempArr[index++] = arr[LPoint++];
        }
        while (RPoint <= right){
            tempArr[index++] = arr[RPoint++];
        }
        for(int i = 0; i < tempArr.length; i++){
            arr[left + i] = tempArr[i];
        }
        return result;
    }






























    /**
     * 归并排序
     * @return
     */
    public static int mergeSort2(int[] arr, int left, int right){
        if(left >= right){
            return 0;
        }
        int mid = (left + right) >> 1;
        return mergeSort2(arr, left, mid) +
                mergeSort2(arr, mid + 1, right)+
        merge3(arr, left, mid, right);
    }
    private static int mergeSort2(int[] arr) {
        return mergeSort2(arr, 0, arr.length - 1);
    }
    private static int merge3(int[] arr, int left, int mid, int right) {
        int low = left;
        int high = mid + 1;
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        int sum = 0;
        while (low <= mid && high <= right){
            if(arr[low] > arr[high]){
                sum += arr[high] * (low - left + 1);
            }
            if(arr[low] <= arr[high]){
                tempArr[index++] = arr[low++];
            }else {
                tempArr[index++] = arr[high++];
            }
        }
        while (low <= mid){
            tempArr[index++] = arr[low++];
        }
        while (high <= right){
            tempArr[index++] = arr[high++];
        }
        for(int i = 0; i < tempArr.length; i++){
            arr[left + i] = tempArr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        //1*4+2*3+ = 25
        int[] arr = {5,4,3,2,1};
        /*int[] arr = BaseUtils.randomArray(15);*/
        System.out.println(Arrays.toString(arr));
        int i = mergeSort2(arr);
        System.out.println(i);
    }
}
