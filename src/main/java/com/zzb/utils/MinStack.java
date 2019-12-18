package com.zzb.utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 15:48 2019/3/15
 */
public class MinStack {
    int[] stack;
    int size;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[10];
        size = 0;
    }

    public void push(int x) {
        //是否扩容
        if(size >= stack.length){
            int[] newArr = new int[stack.length<<1];
            for(int i = 0;i < stack.length; i++){
                newArr[i] = stack[i];
            }
            stack = newArr;
        }
        stack[size] = x;
        size++;
    }

    public void pop() {
        //获得栈尾元素

        //从栈中删除栈尾元素
        int[] newArr = new int[stack.length];
        for(int i = 0;i < size-1; i++){
            newArr[i] = stack[i];
        }
        stack = newArr;
        size--;
    }

    public int top() {
        return stack[size - 1];
    }

    public int getMin() {
        if(size == 0){
            return -1;
        }
        int minElement = stack[0];
        for(int i = 0; i < stack.length; i++ ){
            if(stack[i]<minElement){
                minElement = stack[i];
            }
        }
        return minElement;
    }

    /**
     * 快速排序,定义一个基准值，将数组分别从前往后和从后往前遍历，将低于这个基准值的放在前面，高于基准值的放在后面
     * @param arr 需要排序的数组
     * @param start 排序开始的元素的下标
     * @param end 排序结束的元素的下标
     */
    public static void quickSort(int[] arr,int start, int end){
        if(arr==null || arr.length == 0 || start>=end){
            return;
        }
        int target = arr[start];
        //用于从前往后遍历的指针
        int low = start;
        //用于从后往前遍历的指针
        int high = end;

        while(low<high){
            //从后往前遍历，一直到获得的元素低于基准值，则将这个元素把low指针所在位置的元素替换掉
            while(low < high && arr[high] >= target){
                high--;
            }
            arr[low] = arr[high];
            //从前往后遍历，一直到获得的元素高于基准值，则将这个元素把high指针所在位置的元素替换掉
            while(low < high && arr[low] <= target){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = target;
        System.out.println(Arrays.toString(arr));
        //已经将这个数组拆分为两部分，前面的部分低于基准值，后面的部分高于基准值，分别将这两部分递归，直至两个指针指向同一个位置
        quickSort(arr, start, low);
        quickSort(arr, low+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {21,13,45,37,52,14,16,84,120,12};
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int target = arr[i];
            int j;
            for(j = i; j >0 && target < arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = target;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void removeNext(ListNode node){
        if(node!=null && node.next != null){
            if(node.next.next != null){
                //直接将当前节点的next指向当前节点的下下个节点
                node.next = node.next.next;
            }else{
                node.next = null;
            }
        }
    }
    public static ListNode removeElements(ListNode head, int val) {

        //构建一个新的链表
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode result = newNode;
        //循环遍历链表
        while(result!=null && result.next != null){
            if(result.next.val == val){
                removeNext(result);
            }
            //指向下一个节点
            result = result.next;
        }
        return newNode.next;
    }

    /**
     * 归并排序，将一个数组从中间拆分为两个数组，将这两个数组按位进行比较，将较小的数组存放与一个临时数组中
     * @param arr
     * @param mid
     * @param low
     * @param high
     */
    public static void merge(int[] arr, int low, int mid, int high){
        int[] tempArr = new int[high-low+1];
        //第一个数组从low位置开始排序，一直到mid位置
        int i = low;
        //第二个数组
        int j = mid+1;
        //临时数组的下标
        int index = 0;
        while(i<=mid && j<=high){
            if(arr[i] <= arr[j]){
                tempArr[index] = arr[i++];
            }else {
                tempArr[index] = arr[j++];
            }
            index++;
        }
        //将两个数组比较完成后，可能第一个数组还有剩余的元素
        while(i<=mid){
            tempArr[index++] = arr[i++];
        }
        //将两个数组比较完成后，可能第二个数组还有剩余的元素
        while(j<=high){
            tempArr[index++] = arr[j++];
        }

        //最后，将临时数组赋值给arr
        for(int k = 0; k < tempArr.length; k++){
            arr[k+low] = tempArr[k];
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr,low, mid, high);
        System.out.println(Arrays.toString(arr));
    }
    /*public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
        }
    }*/
}
