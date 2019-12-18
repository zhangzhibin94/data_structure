package com.zzb.dataStructure.linkedlist;

import java.util.HashSet;

/**
 * @Author by 张志斌 .
 * @Date 10:20 2019/4/22
 * 判断两个链表是否相交
 */
public class IntersectList {
    public ListNode intersectList(ListNode head1, ListNode head2){
        ListNode loop1 = hasRing2(head1);
        ListNode loop2 = hasRing2(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1,head2, loop1, loop2);
        }
        return null;
    }
    /**
     *  1.判断两个链表是否有环
     *  方法一：使用一个hashSet存放已经遍历过的节点，每次遍历的时候都判断该节点是否在hashSet中已经存在
     */
    public ListNode hasRing1(ListNode head){
        HashSet<ListNode> repeatNode = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (repeatNode.contains(cur)){
                return cur;
            }
            repeatNode.add(cur);
            cur = cur.next;
        }
        return null;
    }

    /**
     * 判断单链表是否有环
     * 方法二：使用快慢指针，快指针一次走两步，慢指针一次走一步，
     * 当他们相遇的时候必然是在环上,快指针立刻回到节点头部，
     * 变成一次走一步，快慢指针再次相遇的时候肯定在入环节点上
     * @param head
     * @return
     */
    public ListNode hasRing2(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        //慢指针一次走一步
        ListNode low = head.next;
        //快指针一次走两步
        ListNode fast = head.next.next;
        while (low != fast){
            //有空节点说明不是环
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            low = low.next;
            fast = fast.next.next;
        }
        //相遇后快指针回到头并且一次走一步
        fast = head;
        while (low != fast){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    /**
     * 2.单链表有环的情况下求相交的第一个节点
     * @param node1
     * @param node2
     * @return
     */
    public ListNode bothLoop(ListNode node1, ListNode node2, ListNode loop1, ListNode loop2){
        //1.如果是66形式的则没有相交的节点
        //2.如果是Y形的，则跟两个无环单链表相交相似
        //3.如果是兄形的，则在遍历第一个链表的时候，再它走到自身节点之前的节点中是否有node2入环的节点
        //判断是2还是3就看他们入环的节点是否是同一个节点,如果相同就是2，不相同就是3
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        if(loop1 == loop2){
            //1.获得有环链表1的长度
            int count = 0;
            while (cur1 != loop1){
                count++;
                cur1 = cur1.next;
            }
            int count2 = 0;
            while (cur2 != loop2){
                count2++;
                cur2 = cur2.next;
            }
            cur1 = node1;
            cur2 = node2;
            while (count > count2){
                cur1 = cur1.next;
                count--;
            }
            while (count2 > count){
                cur2 = cur2.next;
                count2--;
            }
            //同时开始向下遍历
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
           while (cur1 != loop1){
               if(cur1 == loop2){
                   return  cur1;
               }
               cur1 = cur1.next;
           }
           return null;
        }
    }
    /**
     * 3.单链表无环的情况下求相交的第一个节点
     */
    public ListNode noLoop(ListNode node1, ListNode node2){
        //1.获得两个单链表的长度
        int length1 = getLength(node1);
        int length2 = getLength(node2);
        //2.长的链表走N步，N为两个链表的长度差，以保证两个链表的起点相同
        while (length1 > length2){
            node1 = node1.next;
            length1--;
        }
        while (length1 < length2){
            node2 = node2.next;
            length2--;
        }
        //3.两个链表同时开始遍历，判断是否有相同的节点
        while (node1 != null){
            if(node1 == node2){
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    /**
     * 获得无环链表的长度
     * @param node
     * @return
     */
    public int getLength(ListNode node){
        int count = 0;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    public static void main(String[] args) {
        IntersectList list = new IntersectList();
        /*IntersectList list = new IntersectList();
        ListNode listNode = new ListNode(1);
        ListNode next  = new ListNode(2);
        ListNode nextNext  = new ListNode(3);
        listNode.next = next;
        next.next = nextNext;
        nextNext.next = next;
        ListNode hasRepeat = list.hasRing2(listNode);*/
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        // 8->6
        head2.next.next.next = head1.next.next.next.next.next;
       /* System.out.println(list.intersectList(head1, head2).val);*/



        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        /*System.out.println(list.intersectList(head1, head2).val);*/
        //    1->2->3->4->5->6->7->4...
        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(list.intersectList(head1, head2).val);
        System.out.println();
    }
}
