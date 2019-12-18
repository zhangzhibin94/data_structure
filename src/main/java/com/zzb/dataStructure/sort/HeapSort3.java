package com.zzb.dataStructure.sort;

import com.zzb.dataStructure.BaseUtils;

import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 15:25 2019/4/19
 */
public class HeapSort3 {
    public static void heapSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            insertHeap(arr, i);
        }
        int heapSize = arr.length - 1;
        BaseUtils.swap(arr, 0, heapSize);
        while (heapSize > 0 ){
            checkHeap(arr, 0, --heapSize);
            BaseUtils.swap(arr, 0, heapSize);
        }
    }

    public static void insertHeap(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            BaseUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 向下检查
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void checkHeap(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left <= heapSize){
            int largestNode = left + 1 <= heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largestNode = arr[index] > arr[largestNode] ? index : largestNode;
            if(index == largestNode){
                break;
            }
            BaseUtils.swap(arr, index, largestNode);
            index = largestNode;
            left = 2 * index + 1;
        }
    }


    public static void main(String[] args) {
        /*int[] ints = BaseUtils.randomArray(15);
        System.out.println(Arrays.toString(ints));
        heapSort(ints);
        System.out.println(Arrays.toString(ints));*/
        for(int i = 0; i < 10000; i++){
            int[] arr = BaseUtils.randomArray(2000);
          /*  System.out.println(Arrays.toString(arr));*/
            heapSort(arr);
            int[] copyArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(copyArr);
            if(!Arrays.equals(arr, copyArr)){
                System.out.println(Arrays.equals(arr, copyArr));
            }
        }
    }
}
