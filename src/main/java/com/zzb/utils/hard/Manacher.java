package com.zzb.utils.hard;


import com.sun.tools.javac.util.Convert;

public class Manacher {
    /**
     * 寻找字符串中的最长回文子串
     * @param str
     * @return
     */
    public String maxStr(String str){
        if(str == null || str.length() < 1){
            return "";
        }
        String newstr = insertStr(str);
        //用于记录当前回文半径
        int[] pArr = new int[newstr.length()];
        //1.最右回文点指针
        int R = -1;
        //回文中心
        int cur = -1;
        int max = -1;
        char[] chars = newstr.toCharArray();
        int center = -1;
        for(int i = 0; i < chars.length; i++){
//            pArr[i] = R > i ? Math.min(pArr[2 * cur - i], R - i) : 1;
//            while (i + pArr[i] < chars.length && i - pArr[i] > -1){
//                if(chars[i + pArr[i]] == chars[i - pArr[i]]){
//                    pArr[i]++;
//                }else{
//                    break;
//                }
//            }
//            if(i + pArr[i] > R){
//                R = i + pArr[i];
//                cur = i;
//            }
//
//            if(pArr[i] > max){
//                max = pArr[i];
//                center = i;
//            }
           pArr[i] = R > i ? Math.min(R - i, pArr[2 * cur - i]) : 1;
           //只可能是i的最右边界超过了当前cur的最右边界，那么继续匹配
           while (i + pArr[i] < chars.length && i - pArr[i] > - 1 && chars[i + pArr[i]] == chars[i - pArr[i]] )
               pArr[i]++;
           if(i + pArr[i] > R){
                cur = i;
                R = i + pArr[i];
           }
           if(max < pArr[i]){
               center = i;
               max = pArr[i];
           }

        }

        return str.substring((center - max) / 2, (center - max) / 2 + max - 1);
    }

    private String  insertStr(String str) {
        StringBuilder sb = new StringBuilder("$#");
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i) + "#");
        }
        return sb.toString();


    }

    public static void main(String[] args) {
        String str = "abcddcbaabc";
        Manacher m = new Manacher();
        System.out.println(m.maxStr(str));

    }
}
