package com.zzb.dataStructure.linkedlist;

import com.zzb.dataStructure.BaseUtils;

/**
 * @Author by 张志斌 .
 * @Date 17:09 2019/4/22
 */
public class PartitionList {

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     你应当保留两个分区中每个节点的初始相对位置。
     * @param head
     */
    public ListNode partitionList(ListNode head, int x){
        ListNode less = null;
        ListNode eqAndMore = null;
        ListNode endLess = null;
        ListNode endEqAndMore = null;
        while (head != null){
            if(head.val < x){
                if(less == null){
                    less = head;
                    endLess = head;
                }else {
                    endLess.next = head;
                    endLess = head;

                }
            }else{
                if(eqAndMore == null){
                    eqAndMore = head;
                    endEqAndMore = head;
                }else{
                    endEqAndMore.next = head;
                    endEqAndMore = head;

                }
            }
            head = head.next;
        }
        if(less != null){
            endLess.next = eqAndMore;
            endEqAndMore.next = null;
        }
        return less != null ? less : eqAndMore;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(4);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(2);
        test1.next.next.next.next = new ListNode(5);
        test1.next.next.next.next.next = new ListNode(2);
       /* ListNode head = BaseUtils.randomListNode(10);*/
        BaseUtils.printListNode(test1);
        PartitionList p = new PartitionList();
        ListNode listNode = p.partitionList(test1, 3);
        BaseUtils.printListNode(listNode);
    }
}
