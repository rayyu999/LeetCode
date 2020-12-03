package datastructure;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.empty() && s2.empty()) return -1;
        if (s2.empty()) {
            while (!s1.empty()) s2.push(s1.pop());
        }
        return s2.pop();
    }

}
