package com.zzb.utils;

import com.zzb.utils.tree.Node;

import java.util.Random;

public class BaseUtils {

    public static final Random random = new Random();
    public static int[] randomArray(int size, int start, int end){
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++){
            arr[i] = randomInt(start, end);
        }
        return arr;
    }

    public static int randomInt(int start, int end){

        int i = random.nextInt(end - start);
        return i + start;
    }

    public static Node randomNode(int size, int start, int end){
        Node node = new Node(0);
        Node cur = node;
        while (size != 0){
            Node node2 = new Node(randomInt(start, end));
            cur.next = node2;
            cur = cur.next;
            size--;
        }
        return node.next;
    }

    public static Node randomNode(int size){
        return randomNode(size, 0, 100);
    }

    public static void printNode(Node node){
        while (node != null){
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }
}
