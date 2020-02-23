package com.zzb.dataStructure.linkedlist;

import com.zzb.dataStructure.BaseUtils;

/**
 * @Author by 张志斌 .
 * @Date 11:00 2019/4/22
 * 反转单链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode lastNode = head;
        ListNode cur = head.next;
        lastNode.next = null;
        while (cur != null){
            ListNode tempNext = cur.next;
            cur.next = lastNode;
            lastNode = cur;
            cur = tempNext;
        }
        return lastNode;
    }

    /**
     * 反转从m个到n个的节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for(int i = 0; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int j = 0; j < n; j++){
            ListNode tempNext = head.next;
            head.next = head.next.next;
            tempNext.next = head;
            pre.next = tempNext;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode listNode = BaseUtils.randomListNode(15);
        BaseUtils.printListNode(listNode);
        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.reverseList(listNode);
        BaseUtils.printListNode(head);
    }
}
