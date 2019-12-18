package com.zzb.utils.hard;

public class KMP {
    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if("".equals(haystack) || "".equals(needle) || haystack == null || needle == null){
            return -1;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        //1。求next数组
        int[] next = getNext(needles);
        //2.匹配两个字符串
        int index1 = 0;
        int index2 = 0;
        while (index1 < haystacks.length && index2 < needles.length){
            if( haystacks[index1] == needles[index2]){
                index1++;
                index2++;
            }else if(index2 == 0){
                index1++;
            }else{
                index2 = next[index2];
            }
        }
        return index2 == needles.length - 1 ? index2 - index1 : -1;
    }

    /**
     * 求next数组
     * @param needle
     * @return
     */
    public int[] getNext(char[] needle){
        if(needle.length == 1){
            return new int[]{-1};
        }
        /*int[] next = new int[needle.length];
        //0,1位置固定为-1,0
        next[0] = -1;
        next[1] = 0;
        //指向最长前缀的指针
        int maxPre = 0;
        //当前元素
        int index = 2;
        while (index < next.length){
            if(needle[index - 1] == needle[maxPre]){
                next[index++] = ++maxPre;
            }else if(maxPre > 0){
                maxPre = next[maxPre];
            }else{
                next[index++] = 0;
            }
        }
        return next;*/


























        //求next数组
        int[] preArr = new int[needle.length];
        //1.最长前缀的指针
        int max = -1;
        //当前元素的指针
        int index = 0;
        while( index < needle.length){
            if(needle[index - 1] == needle[max]){
                preArr[index] = ++max;
                index++;
            }else if(max > 0){
                preArr[max] = preArr[preArr[max]];
            }else {
                preArr[index++] = 0;
            }
        }
        return preArr;
    }
}
