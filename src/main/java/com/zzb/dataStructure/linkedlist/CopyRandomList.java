package com.zzb.dataStructure.linkedlist;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author by 张志斌 .
 * @Date 17:17 2019/4/19
 */
public class CopyRandomList {
    public static RandomListNode CopyRandomList(RandomListNode head){
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>(16);
        RandomListNode cur = head;
        while (cur != null){
            RandomListNode copyNode = new RandomListNode(cur.val);
            hashMap.put(cur, copyNode);
            cur = cur.next;
        }
        cur = head;
        RandomListNode randomListHead = hashMap.get(cur);
        while (cur != null){
            RandomListNode randomListNode = hashMap.get(cur);
            randomListNode.next = hashMap.get(cur.next);
            randomListNode.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return randomListHead;
    }
    public static RandomListNode CopyRandomList2(RandomListNode head){
        RandomListNode cur = head;
        RandomListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new RandomListNode(cur.val);
            cur.next.next = next;
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode res = head.next;
        RandomListNode copyNode = null;
        while (cur != null && cur.next != null){
            copyNode = cur.next;
            copyNode.next = cur.next.next;
            if(cur.random != null){
                copyNode.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        return res;
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode cur = head;
        RandomListNode copy = null;
        //复制next
        while (cur != null){
            copy = new RandomListNode(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur  = copy.next;
        }
        //复制random
        cur = head;
        while(cur != null){
            copy = cur.next;
            if(cur.random != null){
                copy.random = cur.random.next;
            }
            cur = copy.next;
        }
        //拆分链表
        cur = head.next;
        while (head != null){
            copy = head.next;

            head.next = copy.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            head = head.next;
        }
        return cur;
    }
    public static void main(String[] args) {
        RandomListNode randomListNode = new RandomListNode(1);
        RandomListNode next = new RandomListNode(3);
        RandomListNode nextNext = new RandomListNode(4);

        randomListNode.next = next;
        randomListNode.random = nextNext;
        next.next = nextNext;
        next.random = randomListNode;
        RandomListNode randomListNode1 = copyRandomList(randomListNode);
        System.out.println();
    }
}
