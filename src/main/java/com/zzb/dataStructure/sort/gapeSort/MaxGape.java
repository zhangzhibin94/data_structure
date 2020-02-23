package com.zzb.dataStructure.sort.gapeSort;

/**
 * @Author by 张志斌 .
 * @Date 10:05 2019/4/15
 * 桶排序：有一个无序数组，求这个数组（长度为N）排序后相邻两个数的最大差值，复杂度为O(N)
 * 思路：将这个数组分成N+1个桶，那么必然有一个空桶，求相邻两个非空桶的最大差值
 * 就是求左边桶的最大值和右边桶的最小值的差值中最大的
 * 1,5  6,9, 11  15
 */
public class MaxGape {
    public static int maxGape(int[] arr){
        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        boolean[] isEmpty = new boolean[arr.length + 1];
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //入桶
        for(int i = 0; i < arr.length; i++){
            int bid = findGape(arr, arr[i], max, min);

            maxs[bid] = isEmpty[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            mins[bid] = isEmpty[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            isEmpty[bid] = true;
        }
        //比较最大邻值
        int result = -1;
        int lastMax = maxs[0];
        for(int i = 1; i <= arr.length; i++){
            if(isEmpty[i]){
                result = Math.max(mins[i] - lastMax, result);
                lastMax = maxs[i];
            }

        }
        return result;
    }

    /**
     * 求当前数target应该在第几个桶中
     * @param arr
     * @param target
     * @return
     */
    public static int findGape(int[] arr, int target, int max, int min){
        return (target - min) * arr.length / (max - min);
    }








    public static int maxGape2(int[] arr){
        //1.求最大值和最小值
        int min = arr[0];
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int len = arr.length + 1;
        int[] maxGape = new int[len];
        int[] minGape = new int[len];
        boolean[] notEmptyGape = new boolean[len];
        for(int i = 0; i < arr.length; i++){
            int bid = getIndex(arr, min, max, arr[i]);
            maxGape[bid] = notEmptyGape[bid] ? Math.max(maxGape[bid], arr[i]) : arr[i];
            minGape[bid] = notEmptyGape[bid] ? Math.min(minGape[bid], arr[i]) : arr[i];
            notEmptyGape[bid] = true;
        }
        int result = -1;
        int lastMax = maxGape[0];
        for(int i = 1; i <= arr.length; i++){
            if(notEmptyGape[i]){
                result = Math.max(minGape[i] - lastMax, result);
                lastMax = maxGape[i];
            }
        }
        return result;

    }

    private static int getIndex(int[] arr, int min, int max,int target) {
        return (target - min) * arr.length / (max - min);

    }

    public static void main(String[] args) {
        int[] arr = {6,11,3,2,11,7,9};
        System.out.println(maxGape2(arr));
    }
}
