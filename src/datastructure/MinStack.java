package datastructure;

import java.util.Stack;

/**
 * @Author Ray
 * @Date 2021/6/2 22:02
 * @Description 155.最小栈
 */
public class MinStack {

    // 储存元素的栈
    Stack<Integer> stack;
    // 储存最小元素的栈，栈顶为当前栈内的最小元素
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */