package com.zzb.dataStructure.linkedlist;

import com.zzb.dataStructure.hashmap.Node;

/**
 * @Author by 张志斌 .
 * @Date 10:16 2019/4/17
 *
 */
public class PublicLinekedList {
    /**
     * 返回两个链表的公共部分
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode getIntersectionNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while(current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        return current1;
    }
    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        n1.next = new ListNode(0);
        n1.next.next = new ListNode(1);
        n1.next.next.next = new ListNode(8);
        n1.next.next.next.next = new ListNode(4);
        n1.next.next.next.next.next = new ListNode(5);

        ListNode n2 = new ListNode(4);
        n2.next = new ListNode(1);
        n2.next.next = new ListNode(8);
        n2.next.next.next = new ListNode(4);
        n2.next.next.next.next = new ListNode(5);
        PublicLinekedList l = new PublicLinekedList();
        ListNode intersectionNode = l.getIntersectionNode(n1, n2);
        System.out.println();
    }
}
