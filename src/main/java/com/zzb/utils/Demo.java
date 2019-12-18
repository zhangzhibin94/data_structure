package com.zzb.utils;

import java.util.*;

/**
 * Created by 98684 on 2019/2/18.
 * LeetCode刷题
 */
public class Demo {
    volatile String a;
    /*
     */
        public static void main(String[] args) {
            ListNode list1 = new ListNode(1);
            list1.next = new ListNode(3);
            list1.next.next = new ListNode(5);
            ListNode list2 = new ListNode(2);
            list2.next = new ListNode(4);
            list2.next.next = new ListNode(6);
            Merge(list1, list2);
        }
    public static ListNode Merge(ListNode list1,ListNode list2) {

        ListNode result = new ListNode(0);
        ListNode head = result;
        while(list1.next != null && list2.next != null){
            if(list1.val <= list2.val){
                result.next = list1;
                list1 = list1.next;
            }else{
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        if(list1.next != null){
            result.next = list1;
            result = result.next;
        }
        if(list2.next != null){
            result.next = list2;
        }
        return head.next;
    }
        /*
        输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
        输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
        小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,
        但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
        魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币 1,3,7,15
        魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
        小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,
        小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
         */
        public static void magicCoin(int i){
            if(i>=1&&i<=Math.pow(10,9)){
                StringBuilder sb = new StringBuilder();
                while (i>0){
                    if(i%2==0){
                        i = (i-2)/2;
                        sb.append(2+" ");
                    }else {
                        i = (i-1)/2;
                        sb.append(1+" ");
                    }
                }
                System.out.println(sb.toString());
            }else {
                System.out.println("您的输入有误");
            }
        }
        /*
        为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
        例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,
        我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
         */
        public static void  demo2(int i){

            Integer integer = i;
            StringBuilder sb = new StringBuilder(integer.toString()).reverse();//获得相反数
            Integer integer1 = Integer.parseInt(sb.toString())+integer;//将相反数与原来的数相加
            System.out.println(integer1);
        }
        //将一个整数反转
        public static int reverse(int x) {
            Integer i = Math.abs(x);
            int temp;
            StringBuilder sb = new StringBuilder(i.toString());
            String str = sb.reverse().toString();

            if(x<0){
                str = "-" + str;
            }
            try {
                 temp = Integer.parseInt(str);
            }catch (NumberFormatException e){
                return 0;
            }
            return temp;
        }

    /*public static int myAtoi(String str) {
        Integer integer = new Integer("");
        integer.intValue();

    }*/

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        //主要思路是将输入的字符串从后往前遍历，如果当前罗马数字大于后面一位，则加上这个元素，否则相减
        if (s == null || s.length() == 0)  {  return -1;}
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = map.get(s.charAt(s.length()-1));//初始化第一个数为字符串最后一个字符
        for(int i = len - 2; i >=0 ; i--){//从倒数第二个字符开始遍历
            //如果当前字符代表的数字小于其后面的数字，则用总和 - 这个数字
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                result -= map.get(s.charAt(i));
            }else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     示例 1:
     输入: ["flower","flow","flight"]
     输出: "fl"

     示例 2:
     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:所有输入只包含小写字母 a-z 。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        if (strs.length>1) {
            int len = strs[0].length();
            //遍历字符串
            for (int i = 0; i < len; i++) {
                char curr = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length()<=i ||strs[j].charAt(i) != curr) {
                        return sb.toString();
                    }
                    if (strs[j].charAt(i) == curr && j == strs.length - 1) {
                        sb.append(curr);
                    }
                }
            }
        }
        return sb.toString();

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k <nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] ==0){



                                    List<Integer> oneResult = new ArrayList<>();
                                    oneResult.add(i);
                                    oneResult.add(j);
                                    oneResult.add(k);
                                    if(result!=null && result.size()>0){

                                            for(List<Integer> list : result){
                                                if(!(list.contains(nums[i])&&list.contains(nums[j])&&list.contains(nums[k]))){
                                                    result.add(oneResult);
                                                }
                                            }

                                    }else {
                                        result.add(oneResult);
                                    }





                    }
                }
            }
        }
        return result;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。
     示例 1:
     输入: "()"
     输出: true
     示例 2:
     输入: "()[]{}"
     输出: true
     示例 3:
     输入: "(]"
     输出: false
     示例 4:
     输入: "([)]"
     输出: false
     示例 5:
     输入: "{[]}"
     输出: true
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //通过栈实现，如果压入的元素和栈顶元素正好可以匹配，则将栈顶元素出栈
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }
    //同上，用linkedList实现
    public static boolean isValid2(String s) {
        //用linkedList实现栈
        char[] chars = s.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        //遍历字符串中的元素，每次入栈前检查他的前一个元素是否和它匹配成一个括号，如果匹配则将栈顶元素出栈，否则进栈
        for(int i = 0; i < chars.length; i++){
            if(linkedList.size()==0){
                linkedList.addFirst(chars[i]);
            }else if(isSym(linkedList.getFirst(),chars[i])){
                linkedList.removeFirst();
            }else {
                linkedList.addFirst(chars[i]);
            }
        }
        return linkedList.size() == 0;
    }

    private static boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
    //合并两个链表并进行排序
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 新建一个结果链表
        ListNode newList = new ListNode(0);
        ListNode returnResult = newList;
        while(l1 !=null && l2 != null){
            if(l1.val<l2.val){
                returnResult.next = new ListNode(l1.val);//将这个链表的节点指向这个节点
                l1 = l1.next;
            }else{
                returnResult.next = new ListNode(l2.val);
                l2 = l2.next;
            }
        }

        return newList.next;
    }
    //删除数组找那个的重复元素，并且保证时间复杂度为O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {return 0;}
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    //递归实现查找一个数组中的最大数,从数组中间将数组一分为二，
    // 获得左边数组的最大值与右边数组的最大值，比较两个最大值并取大的一个
    //getMax（）方法用于获取从起始位置 left，到结束为止right的最大值
    public static int getMax(int[] arr, int left, int right){
        if(left == right){
            return arr[right];
        }
        int mid = (left + right) /2;
        int maxLeft = getMax(arr, left , mid);
        int maxRight = getMax(arr, mid + 1 , right);
        return Math.max(maxLeft, maxRight);
    }

    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end){
        if(arr.length == 0 || start >= end){
            return;
        }
        //选取一个基准值
        int target = arr[start];
        int low = start;
        int high = end;
        while(low < high){
            while(low < high && arr[high] >= target){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= target){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = target;
        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, low);
        quickSort(arr, low+1, end);
    }

    public static int binaryFind(int start, int end, int value){
        if(start>=end){
            return -1;
        }
        int low = start;
        int mid = (start + end) / 2;
        int high = end;
        if(value == mid){
            return mid;
        }

        binaryFind(low, mid, value);
        binaryFind(mid+1, high, value);
        return -1;
    }
}
