package com.zzb.dataStructure.linkedlist;

import java.util.Stack;

/**
 * @Author by 张志斌 .
 * @Date 13:55 2019/4/17
 * 判断一个链表是否是回文结构
 */
public class BackList {
    /**
     * 方式1：遍历链表，将所有元素存在一个栈中(那么每次出栈的时候都是从末尾取，相当于将整个链表逆序了)，
     * 再遍历链表，遍历一个元素弹一个栈顶元素。此方法最简单，但是效率最低，
     * @param head
     * @return
     */
    public boolean isBackList1(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode node1 = head;
        while(node1 != null){
            stack.push(node1);
            node1 = node1.next;
        }
        while (head != null){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;

    }

    /**
     * 方拾二，使用快慢指针，快指针一次走两步，慢指针一次走一步。快指针走完的时候慢指针正好走到中点。
     * 然后将后半部分链表逆序，从头和尾开始一起遍历并比较，只要有一个元素不同就
     * @param head
     * @return
     */
    public boolean isBackList2(ListNode head){
        ListNode low = head;
        ListNode fast = head;
        ListNode head1 = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            low = low.next;
            fast = fast.next.next;
        }

        ListNode current = low.next;
        ListNode lastNode = low;
        low.next = null;
        while (current != null){
            ListNode temp = current.next;
            current.next = lastNode;
            lastNode = current;
            current = temp;
        }
        ListNode reverseHead = lastNode;
        while (reverseHead != null &&  head1 != null){
            if(reverseHead.val != head1.val){
                return false;
            }
            reverseHead = reverseHead.next;
            head1 = head1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
        BackList backList = new BackList();
        System.out.println(backList.isBackList2(node));
    }
}
