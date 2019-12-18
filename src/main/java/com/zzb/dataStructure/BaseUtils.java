package com.zzb.dataStructure;

import com.zzb.dataStructure.linkedlist.ListNode;

import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 14:32 2019/4/4
 */
public class BaseUtils {
    public static void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static int nextRandomInt(int start, int end){
        if(start >= end){
            return -1;
        }
        Random random = new Random();
        return start + random.nextInt(end - start);
    }
    public static int[]  randomArray(){
       return randomArray(100000);
    }
    public static int[]  randomArray(int size){
        if(size < 0){
            return null;
        }
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = BaseUtils.nextRandomInt(1,1000);
        }
        return arr;
    }
    public static int[]  randomArray(int size, int start, int end){
        if(size < 0){
            return null;
        }
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = BaseUtils.nextRandomInt(start, end);
        }
        return arr;
    }

    public static int[][] randomMatrix(int L,int R,int start, int end){
        int[][] result = new int[L][R];
        for(int i = 0; i < L; i++){
            for(int j = 0; j < R; j++){
                result[i][j] =  BaseUtils.nextRandomInt(start, end);
            }
        }
        return result;
    }
    public static int[][] randomMatrix(int L,int R){
        return randomMatrix(L,R,0,100);
    }

    public static void printMatrix(int[][] m){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if( i == m.length - 1 && j == m[0].length - 1){
                    sb.append(m[i][j]);
                }else{
                    sb.append(m[i][j]+",");
                }
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    public static ListNode randomListNode(int size){
        return randomListNode(size,1,50);
    }
    public static ListNode randomListNode(int size, int start, int end){
        int[] ints = randomArray(size, start, end);
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i = 0 ; i < ints.length; i++){
            ListNode nextNode = new ListNode(ints[i]);
            current.next = nextNode;
            current = current.next;
        }
        return head.next;
    }

    public static void printListNode(ListNode head){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null){
            if(head.next == null){
                sb.append(head.val);
            }else {
                sb.append(head.val+", ");
            }
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
