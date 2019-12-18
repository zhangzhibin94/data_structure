package com.zzb.dataStructure.stackandqueue;

import java.util.Stack;

/**
 * @Author by 张志斌 .
 * @Date 16:49 2019/4/15
 * 求栈的最小值，要求时间复杂度为O(1)
 * 思路：使用两个栈，第一个栈就正常的出栈入栈，
 * 第二个栈的第一个元素为正常的，当入栈的时候的元素小于这个元素则入第二个栈的元素就是这个元素，
 * 否则复制一个当前元素到栈顶
 */
public class StackDemo {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer value){
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        Integer top = minStack.peek();
        if(value < top){
            minStack.push(value);
        }else {
            minStack.push(top);
        }
    }
    public Integer pop(){
        minStack.pop();
        return stack.pop();
    }

    public Integer getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        stackDemo.push(3);
        stackDemo.push(4);
        stackDemo.push(5);
        stackDemo.push(1);
        stackDemo.push(2);
        stackDemo.push(2);
        System.out.println(stackDemo.getMin());
        stackDemo.pop();
        stackDemo.pop();
        stackDemo.pop();
        stackDemo.pop();
        System.out.println(stackDemo.getMin());
    }
}
