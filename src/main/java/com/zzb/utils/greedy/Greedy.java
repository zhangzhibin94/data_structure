package com.zzb.utils.greedy;

import com.alibaba.fastjson.JSONObject;
import com.zzb.utils.BaseUtils;

import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;

public class Greedy {

    /**
     * 求会议室可以使用的最大次数
     * @Param programs：所有的项目
     * @Param cur:当前时间
     * @return
     */
    public int bestRange(Program[] programs, int cur){
        int count = 0;
        //根据结束时间排序，结束时间早的在前
        Arrays.sort(programs, new MyCompare());
        for(int i = 0; i < programs.length; i++){
            if(programs[i].start >= cur){
                count++;
                cur = programs[i].end;
            }
        }
        return count;
    }

    /**
     * 求第k大的数
     * @param arr
     * @param k
     * @return
     */
    public int firstK(int[] arr, int k){
        return this.partition(arr, 0, arr.length - 1, k);

    }

    public int partition(int[] arr, int low, int high ,int k){
        int left = low;
        int right = high;
        int target = low;
        while (left < right){
            while (left < right && arr[right] >= arr[target]){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= arr[target]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = arr[target];
        if(k == left){
            return arr[target];
        }else if(k < left){
            return partition(arr, low, left, k);
        }else{
            return partition(arr, left + 1, high, k);
        }
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        int high = chars.length - 1;
        int low = 0;
        while(low < high){
            while((low < high) && !((chars[low] >= '0' && chars[low] <= '9')) || ((chars[low] >= 'a' && chars[low] <= 'z'))){
                low++;
            }
            while((low < high) && !((chars[high] >= '0' && chars[high] <= '9')) || ((chars[high] >= 'a' && chars[high] <= 'z'))){
                high--;
            }
            if(low < high && chars[low] != chars[high]){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        Greedy g = new Greedy();
        int[] arr = BaseUtils.randomArray(10, 0,10000);
        System.out.println(Arrays.toString(arr));
//        int partition = g.firstK(arr,3);
        g.isPalindrome("A man, a plan, a canal: Panama");

    }
}
class Program{
    public int start;
    public int end;

    public Program(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MyCompare implements Comparator<Program>{

    @Override
    public int compare(Program o1, Program o2) {
        return o1.end - o2.end;
    }
}
