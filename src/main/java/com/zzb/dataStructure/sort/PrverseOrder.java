package com.zzb.dataStructure.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 16:49 2019/4/9
 */
public class PrverseOrder {
    int count = 0;
    //归并排序每个数之间都只会比较一次，一次不多一次不少
    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return count;
    }
    public void mergeSort(int[] arr,int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    public void merge(int[] arr, int left, int mid, int right){
        if(left >= right){
            return;
        }
        int[] tempArr = new int[right- left + 1];
        int index = 0;
        int low = left;
        int high = mid + 1;
        while(low <= mid && high <= right){
            if(arr[low] <= arr[high]){
                tempArr[index++] = arr[low++];
            }else{
                count++;
                tempArr[index++] = arr[high++];
            }
        }
        while(low <= mid){
            tempArr[index++] = arr[low++];
        }
        while(high <= right){
            tempArr[index++] = arr[high++];
        }
        for(int i = 0; i < tempArr.length; i++){
            arr[left + i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
//        int[] arr = {1,3,4,2};
        PrverseOrder order = new PrverseOrder();
        order.InversePairs(arr);
        System.out.println(Arrays.toString(arr));
    }
}
