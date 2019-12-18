package com.zzb.dataStructure.stackandqueue;

import java.util.Stack;

/**
 * @Author by 张志斌 .
 * @Date 17:02 2019/4/15
 * 使用栈实现队列
 */
public class QueueByStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public void push(Integer value){
        stack.push(value);
    }

    public Integer pop(){
        while (!stack.isEmpty()){
            help.push(stack.pop());
        }
        Integer result = help.pop();
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        QueueByStack stack = new QueueByStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
