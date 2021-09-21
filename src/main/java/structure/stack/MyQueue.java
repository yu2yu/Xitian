package structure.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 用栈实现队列
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 先判断out栈是否为空
        if(stackOut.isEmpty()){
            // 从stackIn弹出来
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        // 先判断out栈是否为空
        int pop = pop();
        push(pop);
        return pop;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    @Test
    public void testMyQueue(){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);

        assertEquals(1,queue.peek());
        assertEquals(1,queue.pop());
        assertEquals(2,queue.peek());
        assertEquals(2,queue.pop());
        assertTrue(queue.empty());
    }

}
