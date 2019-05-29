package com.zzb.utils.tree;

import com.zzb.utils.BaseUtils;

import java.util.Arrays;
import java.util.Base64;

/**
 * 数组
 */
public class ArrayTest {
    /**
     * 找出数组中的任意一个重复数字，数组中元素的大小在0～n-1，n为数组长度
     * @param array
     * @return
     */
    public int findDuplicateNumber(int[] array){
        for(int i = 0; i < array.length; i++){
            //一直将当前元素和以当前元素为下标的元素位置交换，知道当前元素的值和下标相同
            while (array[i] != i){
                if(array[i] == array[array[i]]){
                    return array[i];
                }
                swap(array, array[i], array[array[i]]);
            }

        }
        return -1;
    }

    /**
     * 找出数组中的任意一个重复数字，数组中元素的大小在0～n-1，n为数组长度。
     * 不允许更改数组中的元素
     * 思路：将数组分为两部分，0～m，m+1～n。0～m在数组中出现的次数是否超过0～m的长度，
     * 如果超过，则表示当中存在重复的数字。否则在m+1～n中存在重复的数字。一直二分直到找到重复的数字。
     * 时间复杂度为O(NlgN)
     * @param array
     * @return
     */
    public int findDuplicateNumber2(int[] array){

        int start = 0;
        int end = array.length - 1;
        while (start <= end){
            int mid = (end - start) / 2 + start;
            int count = getCount(array, start,  mid);
            if(start == end){
                if (count > 1){
                    return array[start];
                }else {
                    break;
                }
            }
            if(count > mid - start + 1){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return -1;

    }

    /**
     * 统计在start~end位置一共有多少个元素
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int getCount(int[] array, int start, int end) {
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] >= start && array[i] <= end){
                count++;
            }
        }
        return count;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = index1;
        index1 = index2;
        index2 = temp;
    }

    public String replaceString(String str){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < str.length()){
            if(str.charAt(index) != ' '){
                sb.append(str.charAt(index));
                index++;
            }else{
                while (str.charAt(index) == ' '){
                    index++;
                }
                sb.append("%20");
            }

        }
        return sb.toString();
    }

    public void reversePrintNode(Node node){
        if(node == null){
            return;
        }
        reversePrintNode(node.next);
        System.out.print(node.value+",");

    }

    public Node swapPairs(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node result = head;
        Node fast = head.next;
        Node low = head;
        Node lastNode = null;
        while(fast != null){
            swap(lastNode, fast, low);
            lastNode = low;
            if(fast.next.next == null){
                break;
            }
            fast = fast.next.next.next;
            low = low.next;
        }
        return head;
    }

    public void swap(Node lastNode, Node fast, Node low){
        if(lastNode != null)
            lastNode.next = fast;
        Node temp = fast.next;
        fast.next = low;

        low.next = temp;
        System.out.println();

    }
    public static void main(String[] args) {
      Node node = BaseUtils.randomNode(4,1,10);
      BaseUtils.printNode(node);
      ArrayTest a = new ArrayTest();
      a.swapPairs(node);
      BaseUtils.printNode(node);
    }
}
