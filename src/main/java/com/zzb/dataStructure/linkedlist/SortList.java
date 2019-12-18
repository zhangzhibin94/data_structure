package com.zzb.dataStructure.linkedlist;

import com.zzb.dataStructure.BaseUtils;

/**
 * @Author by 张志斌 .
 * @Date 15:50 2019/4/18
 * 链表排序
 */
public class SortList {
    /**
     * 按照某个值划分成小于等于大于区域
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head, int value) {
        ListNode less = null;
        ListNode equal = null;
        ListNode more = null;
        ListNode current = head;
        while(current != null){
            if(less == null && current.val < value){
                less = current;
            }
            if(more == null && current.val > value){
                more = current;
            }
            if(equal == null && current.val == value){
                equal = current;
            }
            current = current.next;
        }
        ListNode endLess = less;
        ListNode endEq = equal;
        ListNode endMore = more;
        current = head;

        while (current != null){
            if (endLess != null && current.val < value && endLess != current){
                endLess.next = current;
                endLess = endLess.next;
            }else if(endEq != null && current.val == value && endEq != current){
                endEq.next = current;
                endEq = endEq.next;
            }else if(endMore != null && current.val > value && endMore != current){
                endMore.next = current;
                endMore = endMore.next;
            }
            current = current.next;
        }
        if(endLess != null){
            endLess.next = null;
        }
        if(endEq != null){
            endEq.next = null;
        }
        if(endMore != null){
            endMore.next = null;
        }
        ListNode result = new ListNode(0);

        if(less != null){
            result.next = less;
            if(equal != null){
                endLess.next = equal;
                if(more != null){
                    endEq.next = more;
                }
            }else {
                if(more != null){
                    endLess.next = more;
                }
            }
            //less为空
        }else{
            if(equal != null){
                result.next = equal;
                if(more != null){
                    endEq.next = more;
                }
            }else {
                result.next = more;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            ListNode node = BaseUtils.randomListNode(20);
            BaseUtils.printListNode(node);
            ListNode result = sortList(node, 25);
            BaseUtils.printListNode(result);
        }

        /*ListNode test = new ListNode(10);
        test.next = new ListNode(26);
        test.next.next = new ListNode(36);
        test.next.next.next = new ListNode(20);
        test.next.next.next.next = new ListNode(8);
        test.next.next.next.next.next = new ListNode(1);
        test.next.next.next.next.next.next = new ListNode(15);
        test.next.next.next.next.next.next.next = new ListNode(49);
        test.next.next.next.next.next.next.next.next = new ListNode(48);
        test.next.next.next.next.next.next.next.next.next = new ListNode(24);*/

    }
}
