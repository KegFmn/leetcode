package com.likc.data.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */
public class Deques {
        /*用两个栈实现一个队列*/
        class CQueue {

            private Deque<Integer> stack_in;
            private Deque<Integer> stack_out;

            public CQueue() {
                stack_in = new LinkedList<>();
                stack_out = new LinkedList<>();
            }

            public void appendTail(int value) {
                stack_in.push(value);
            }

            public int deleteHead() {
                // 当出栈为空时，把入栈全部元素导入出栈中
                if(stack_out.isEmpty()){
                    while(!stack_in.isEmpty()){
                        stack_out.push(stack_in.pop());
                    }
                }

                // 如果还为空，则返回-1；
                if(stack_out.isEmpty()){
                    return -1;
                } else{
                    // 否则弹出出栈的第一个元素
                    int x = stack_out.pop();
                    return x;
                }
            }
        }

        /*定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。*/
        class MinStack {

            Deque<Integer> stack;
            Deque<Integer> minStack;
            public MinStack() {
                stack = new LinkedList<>();
                minStack = new LinkedList<>();
                // 利于比较大小
                minStack.push(Integer.MAX_VALUE);
            }

            public void push(int x) {
                stack.push(x);
                // 使stack的每一位都对应minStack的最小值
                minStack.push(Math.min(minStack.peek(), x));
            }

            public void pop() {
                stack.pop();
                minStack.pop();
            }

            public int top() {
                return stack.peek();
            }

            public int min() {
                return minStack.peek();
            }
        }

}
