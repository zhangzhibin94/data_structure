package com.zzb.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zzb on 2019/2/11.
 * 选择排序
 */
public class SelectSort {
    private static Integer[] selectSortArray = {1,11,33,5,113,56,99,103,6,15,88,133,890};

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

    public static void main(String[] args) {
        String testString = "{\n" +
                "\"ResponseStatusListObject\": {\n" +
                "\"ResponseStatusObject\": [{\n" +
                "\"Id\":\n" +
                "\"32050800001327000001022019012313191005274\",\n" +
                "\"StatusCode\": 0,\n" +
                "\"RequestURL\": \"/VIID/ SubscribeNotifications \",\n" +
                "\"StatusString\": \"OK\",\n" +
                "\"LocalTime\": \"20180116141531\"\n" +
                "}]\n" +
                "}\n" +
                "}\n";
//log.info("接入耐司捷视图库返回消息 = {}", result);
        Object obj = JSONObject.parseObject(testString, Object.class);

        System.out.println();
    }

}
