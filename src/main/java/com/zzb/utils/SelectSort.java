package com.zzb.utils;



import java.util.Arrays;

/**
 * Created by zzb on 2019/2/11.
 * 简单排序
 */
public class SelectSort {
    private  Integer[] selectSortArray = new Integer[10000];

    private  int aaa = 15;
    //选择排序
    public void sort(Integer[] objects){
        //min用于记录数组中最小的值
        int min=0;
        //将数组中所有的元素进行对比,筛选出值最小的数
        for(int i = 0; i < objects.length; i++){
            min = i;
            for(int j = i+1;j<objects.length;j++){
                if(objects[j]<objects[min]){
                    min = j;
                }
            }
            //交换两个元素->下标分别为min和i
            int temp = objects[min];
            objects[min] = objects[i];
            objects[i] = temp;
        }
    }
    //插入排序：将数组分为有序列表和无序列表，左边是有序，右边是无序，
    //  每次排序只需要将无序列表的第一个元素插入到有序列表中，并保证有序列表保持有序，
    //  复杂度为O（n²）因为比较次数与冒泡排序相同，值
    public void insertSort(Integer[] objects){
        //1.默认数组的左边第一个元素有序，其余元素都是无序的,
        // 将无序列表中的左边第一个元素与有序列表中的最右边的第一个元素比较
        for(int i = 1;i<objects.length;i++){
            int temp = objects[i];//temp变量用于记录无序列表第一个元素（即最左边元素）的值
            int in = i;//额外声明一个变量in是为了in的值不会影响i的值
            //遍历有序列表，如果无序列表的第一个元素（即temp）小于有序列表中的元素
            while(in>0&&temp<objects[in-1]){
                objects[in]=objects[in-1];
                in--;
                System.out.println("while循环输出结果："+Arrays.toString(objects));
            }
            objects[in] = temp;
            System.out.println("--------------------------------------------------");
            System.out.println("第"+i+"次排序结果："+Arrays.toString(objects));
            System.out.println("--------------------------------------------------");
        }
    }
    public static void insertSort2(Integer[] arr)
    {
        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++)
        {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
            System.out.println("第"+i+"次排序结果："+ Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {

    }
    //选择排序，遍历出最小的数放到最右边
    public static void  selectSort(Integer[] arr){

        for(int i = 0; i<arr.length;i++){
            int min = i;//temp为最小数的数组下标
            //获取数组中当前最小的数
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            //交换两个元素
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    //插入排序
    public static void inserSort2(Integer[] arr){
        for(int i = 1; i<arr.length; i++){
            int j = i;
            int temp = arr[i];
            while (j>0&&temp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
