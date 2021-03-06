package stackandqueue;

import java.util.Stack;

public class No232 {

    static class MyQueue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            // 统一推入s1
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (s2.isEmpty()) {
                move();
            }
            return s2.isEmpty() ? -1 : s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (s2.isEmpty()) {
                move();
            }
            return s2.isEmpty() ? -1 : s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if (s2.isEmpty()) {
                move();
            }
            return s2.isEmpty();
        }

        private void move() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

}
