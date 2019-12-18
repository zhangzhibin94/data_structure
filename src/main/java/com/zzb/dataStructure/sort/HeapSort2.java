package com.zzb.dataStructure.sort;

import com.zzb.dataStructure.BaseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author by 张志斌 .
 * @Date 13:32 2019/4/8
 * 堆排序
 */
public class HeapSort2 {
    Stack<Integer> stack = new Stack<>();
    /**
     * 插入大根堆,从第一个节点开始
     */
    public  static void insertHeap(int[] arr, int index){
        int parentNode = (index - 1) / 2;
        //这里已经考虑了父节点不存在的情况，(index - 1) / 2 不可能小于0
        while (arr[index] > arr[parentNode]){
            BaseUtils.swap(arr, index, parentNode);
            //向上检查
            index = parentNode;
        }
    }

    /**
     * @param arr
     * @param index
     * @param heapSize
     * 向下检查index节点的子节点是否保持了大根堆结构
     */
    public static void heapify(int[] arr, int index, int heapSize){
        //左节点
        int leftNode = 2 * index + 1;
        //右节点
        int rightNode = leftNode + 1;
        //如果节点存在左节点则一直循环下去
        while(leftNode < heapSize){
            //将当前节点与它的右节点和左节点分别比较，获得值最大的节点
            //                left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            int largestNode = rightNode < heapSize && arr[rightNode] > arr[index] ? rightNode : index;
            largestNode = arr[leftNode] > arr[largestNode] ? leftNode : largestNode;
            //如果最大的节点还是当前节点，则直接跳出循环
            if(index == largestNode){
                break;
            }
            //交换两个节点的值并继续向下比较
            BaseUtils.swap(arr, index, largestNode);
            //需要比较的节点则为获得最大值的那个节点
            index = largestNode;
            leftNode = 2 * index + 1;
            rightNode = leftNode + 1;
        }
    }

    public  static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            insertHeap2(arr, i);
        }
        //第一次交换堆顶和堆尾元素
        int heapSize = arr.length;
        BaseUtils.swap(arr, 0, --heapSize);
        //一直重新构成大根堆，然后交换堆顶和堆尾元素
        while (heapSize > 0){
            heapify(arr, 0, --heapSize);
            BaseUtils.swap(arr, 0, heapSize);
        }

    }

    /**
     * 插入节点
     * @param arr
     * @param index
     */
    public static void insertHeap2(int[] arr, int index){
        int parentNode = (index - 1) / 2;
        while (arr[index] > arr[parentNode]){
            BaseUtils.swap(arr, index, parentNode);
            index = parentNode;
        }
    }

    public static void main(String[] args) {
       /* int[] arr = {3,7,9,2,4,6};*/
        int[] arr = BaseUtils.randomArray(20);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
