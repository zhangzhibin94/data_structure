package com.zzb.utils;

/**
 * @Author by 张志斌 .
 * @Date 18:35 2019/3/22
 */
public class NumArray {
    int[] arr;
    int sum = 0;
    public NumArray(int[] nums) {
        arr = nums;
    }

    public int sumRange(int i, int j) {
        if(i>=j){
            return 0;
        }
        int temp = arr[i] + arr[j];
        i++;
        j--;
        sum = sum + temp + sumRange(i,j);
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(nums);
        numArray.sumRange(0, 2);
        int i = numArray.sumRange(2, 5);
        System.out.println(i);
    }
}
