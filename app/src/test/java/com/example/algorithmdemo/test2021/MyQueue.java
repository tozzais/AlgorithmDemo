package com.example.algorithmdemo.test2021;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

     Deque<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return  stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
