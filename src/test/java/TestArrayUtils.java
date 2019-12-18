import com.zzb.utils.*;
import com.zzb.utils.Demo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 98684 on 2019/1/31.
 */
public class TestArrayUtils {
  @Test
    public void testArray(){
      String sq = "ABCD";
      String s2 = "DCBA";

      System.out.println();
        List<Long> testIds = new ArrayUtils<>();
        List<Long> testIds2 = new ArrayList<>(15);
        testIds.add(123L);
        testIds.add(1234L);
        testIds.stream().forEach(id->{
            if(id.equals("123")){

            }
        });
        System.out.println(Arrays.toString(testIds.toArray()));
        String name = "1234567890";
        char[] chars = name.toCharArray();

    }
    @Test
    public void testMerge(){

      Demo demo = new Demo();
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(1);
      ListNode temp = new ListNode(1);
      temp.next = l1;
      l1 = l1.next;
      l1.next = new ListNode(2);
      l1 = l1.next;
      l1.next = new ListNode(3);

      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(2);
      l2 = l2.next;
      l2.next = new ListNode(3);
      l2 = l2.next;
      l2.next = new ListNode(4);
      demo.mergeTwoLists(l1,l2);
      System.out.println(temp.next);
      List<String> list = new ArrayList<>();
      int[] arr = {};
      String a = "";
      String[] split = a.split(" ");
      split[split.length-1].length();
      Integer i = 123;

    }
    @Test
    public void testRemoveDuplicates(){
      Demo demo = new Demo();
      int[] nums = {1,3,3,3,5,5,6};
      int i = demo.removeDuplicates(nums);
      System.out.println(i);
      String s1 = "";
      String s2 = "";
      s1.indexOf(s2);
      if(s1.contains(s2)){

      }
    }
@Test
  public void maxSubArray() {
  int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    int res = nums[0];
    int sum = 0;
    for (int num : nums) {
      if (sum > 0)
        sum += num;
      else
        sum = num;
      res = Math.max(res, sum);
    }
  }

  @Test
  public void plusOne() {
    int[] digits = {9, 9, 9, 9};
    //1.判断末尾是否是9，如果是9 则设置为0并且向上找一位是否是9 一直找到不是9的那一位+1
    //从末尾往前找
        for(int i = digits.length - 1; i >=0; i--){
          if(digits[i]==9){
            digits[i] = 0;
          }else {
            digits[i] +=1;
            System.out.println(Arrays.toString(digits));
            return;
          }
        }
        //如果到程序这边，说明原数组全部为9
        int[] arr= new int[digits.length+1];
        System.arraycopy(digits,0,arr,1,digits.length);
        arr[0] = 1;
        double pow = (int)Math.pow(1, 2);
        List<?> list = new ArrayList<>();
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testSpring(){
      /*Arrays.sort();*/
    }
}
