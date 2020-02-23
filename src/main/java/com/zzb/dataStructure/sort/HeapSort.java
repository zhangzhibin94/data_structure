package com.zzb.dataStructure.sort;

import com.zzb.dataStructure.BaseUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 16:02 2019/3/26
 * 堆排序
 */
public class HeapSort {
    /**
     * 大顶堆：根节点大于任何一个孩子节点
     * 将当前节点和其子节点比较，权值大的作为当前节点，并且保证子节点没有破坏大顶堆结构
     * @param arr
     * @param index
     * @param size
     */
    public static void heap(int[] arr,int index, int size){
        if(arr == null || arr.length == 0){
            return;
        }
        //当前节点的左孩子
        int leftChild = 2 * index + 1;
        //当前节点的右孩子
        int rightChild = 2 * index + 2;
        //如果是叶子节点则直接跳出方法,因为不需要比较，叶子节点就是权最大的节点
        if(leftChild >= size && rightChild >= size){
            return;
        }
        //用于指向当前节点及其子节点中最大节点的指针
        int max = index;
        //如果存在左孩子并且左孩子的权比根节点大，则max指针指向左孩子
        if(leftChild < size && arr[leftChild] > arr[max] ){
            max = leftChild;
        }
        //如果存在右孩子并且左孩子的权比左孩子还大，则max指针指向右孩子
        if(rightChild < size && arr[rightChild] > arr[max]){
            max = rightChild;
        }
        //如果指向最大节点的指针没有指向当前节点，说明它的孩子节点中存在比他更大的值，
        if(max != index){
            //交换这两个节点
            swap(arr, index, max);
            //交换位置后，可能破坏了原来的结构，需要将被交换的节点继续执行大顶堆排序
            heap(arr, max, size);
        }
    }

    private static void swap(int[] arr, int index, int max) {

        int temp = arr[index];
        arr[index] = arr[max];
        arr[max] = temp;
    }

    public static void heapSort(int[] arr){
        int lastNode = arr.length - 1;
        int lastLeaf = (lastNode - 1) / 2;
        //从最后一个非叶子节点向前遍历
        for(int i = lastLeaf; i >= 0; i--){
            heap(arr, i, arr.length - 1);

        }
        //排序完成后 交换第一个值和最后一个值并且size--
        for(int i = arr.length - 1; i >= 0; i--){
            swap(arr, 0, i);
            //然后进行下一次大顶堆排序，直接从位置0开始即可，因为交换后最小值放到了堆顶
            heap(arr, 0, i);

        }
    }

    public static void main(String[] args) {
        int[] arr = BaseUtils.randomArray(1000000, 1, 100000);
        long startTime = System.currentTimeMillis();
        heapSort(arr);
       /*Arrays.sort(arr);*/
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
