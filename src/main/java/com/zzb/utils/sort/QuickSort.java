package com.zzb.utils.sort;

import java.util.*;

public class QuickSort {

    public void quickSort(int[] arr, int left, int right, int target){


    }

    public void swap(int[] arr, int cur, int tar){
        int temp = arr[cur];
        arr[cur] = arr[tar];
        arr[tar] = temp;
    }
    /**
     * 快速排序，
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public void partition(int[] arr, int left, int right, int target){
        int low = left;
        int high = right;
        while(left < right){
            while (left < right && arr[high] >= arr[target]){
                high--;

            }
            swap(arr, high, low);
            while (left < right && arr[low] <= arr[target]){
                low++;
            }
            swap(arr,high,low);
        }
        swap(arr, low, target);
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        //短的字符串补0；
        int minusLength = 0;
        if(a.length() > b.length()){
            minusLength = a.length() - b.length();
            //b字符串补0
            while (minusLength > 0){
                StringBuilder s = new StringBuilder(b);
                s.insert(0,"0");
                minusLength--;
                b = s.toString();
            }
        }else if(b.length() > a.length()){
            minusLength = b.length() - a.length();
            while (minusLength > 0){
                StringBuilder s = new StringBuilder(a);
                s.insert(0,"0");
                minusLength--;
                a = s.toString();
            }
        }
        int i = a.length() ;
        int j = b.length() ;
        //需要进plus位
        int plus = 0;
        while(--i >= 0 || --j >= 0){

            int sum = Integer.parseInt(a.charAt(i)+"") + Integer.parseInt(b.charAt(j)+"") + plus;
            int cur = sum % 2;
            plus = sum / 2;
            sb.insert(0, cur +"");

            i--;
            j--;
        }
        while (plus > 0){
            int cur = plus % 2;
            plus = plus / 2;
            sb.insert(0, cur +"");

        }

        return sb.toString();
    }

    public String simplifyPath(String path) {
        if(path == null){
            return "";
        }
        String[] pathList = path.split("/");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < pathList.length; i++){
            if(pathList[i] != null && !pathList[i].equals("")){
                if(pathList[i].equals(".")){
                    if(stack.isEmpty()){

                    }else{
                        continue;
                    }

                }else  if(pathList[i].equals("..")){
                    if(stack.isEmpty()){

                    }else{
                        stack.pop();
                    }

                }else{
                    stack.add(pathList[i]);
                }
            }


        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            if(stack.peek().equals("/")){
                sb.insert(0,"/");
            }else{
                sb.insert(0,"/"+stack.pop());
            }

        }
        return sb.toString();
    }


}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<Node> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1]){
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                intervals[i][0] = Math.min(intervals[i][0], intervals[i -1][0]);
            }else{
                list.add(new Node(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            result[i][0] = list.get(i).start;
            result[i][1] = list.get(i).end;
        }
        return result;
    }

    public static class Node{
        int start;
        int end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1,3}, {2,6}, {8,10}, {15,8}};
        Solution s = new Solution();
        s.merge(test);
    }
}