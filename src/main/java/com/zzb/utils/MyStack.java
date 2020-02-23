package com.zzb.utils;


/**
 * @Author by 张志斌 .
 * @Date 11:07 2019/3/15
 */
public class MyStack {
    private int[] stack;
    private int size;
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new int[10];
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(size >= stack.length){
            resize();
        }
        stack[size++] = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(size==0){
            return -1;
        }
        int topValue = top();
        size--;
        return topValue;
    }

    /** Get the top element. */
    public int top() {
        if(size == 0){
            return -1;
        }
        return stack[size-1];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }

    private void resize(){
        //将数组长度扩大一倍
        int[] newStack = new int[stack.length << 1];
        for(int i = 0; i < stack.length ; i++){
            newStack[i] = stack[i];
        }
        //将原数组指向新数组
        stack = newStack;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.pop();
        myStack.push(5);
        myStack.top();
    }
}

