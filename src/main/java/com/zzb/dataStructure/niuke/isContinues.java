package com.zzb.dataStructure.niuke;

import com.zzb.dataStructure.TreeNode;
import com.zzb.utils.ListNode;

import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 13:56 2019/4/10
 */
public class isContinues {
    /**
     * 1.最大牌比最小牌大 不能超过5
     * 2.除了0（就是大小王）之外不能存在两张一样的牌
     * 3.数组长度 为5（就是必须是5张牌）
     */
    public static boolean isContinuous(int [] numbers) {
        int max = numbers[0];
        int min = numbers[0];
        //用于记录重复的牌
        int[] repeatNumber = new int[5];
        int index = 0;
        for(int i = 0; i < numbers.length; i++){
            if(max == 0){
                max = numbers[i];
            }
            if(min == 0){
                min = numbers[i];
            }
            //除了0（就是大小王）之外不能存在两张一样的牌
            for(int j = 0; j < repeatNumber.length; j++){
                if(numbers[i] == repeatNumber[j] && numbers[i] != 0){
                    return false;
                }
            }
            repeatNumber[index++] = numbers[i];
            if(numbers[i] > max  && numbers[i] != 0){
                max = numbers[i];
            }
            if(numbers[i] < min  && numbers[i] != 0){
                min = numbers[i];
            }
        }
        if(max - min >= 5){
            return false;
        }
        return true;
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode result = pHead;
        ListNode pre = pHead;
        while(pHead != null && pHead.next != null){
            if(pHead.next.val == pHead.val && pre != result){
                pre.next = pHead.next.next;
                pHead = pHead.next.next;
            }else{
                pre = pHead;
                pHead = pHead.next;
            }

        }
        return result;
    }
    public static void pringNode(ListNode node){
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,8,16,32,64,128};
        threeSumClosest(arr, 82);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            int left = i-1;
            int mid = i;
            int right = i+1;
            while(left >= 0 && right <= nums.length - 1 ){
                int temp = nums[left] + nums[mid] + nums[right];
                if(Math.abs(temp - target) < Math.abs(sum - target)){
                    sum = temp;
                }
                //sum = Math.min(Math.abs(temp - target), sum - target);
                if(Math.abs(temp - target) > 0){
                    left--;
                }else if(Math.abs(temp - target) < 0){
                    right++;
                }else{
                    return sum;
                }
            }
        }
        return sum;
    }




}
