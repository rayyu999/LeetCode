package linkedlist;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class JZOffer6 {

    ArrayList<Integer> arr = new ArrayList<>();

    /**
     * 递归
     * @param head
     * @return
     */
    public int[] reversePrint_recur(ListNode head) {
        recur(head);
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) res[i] = arr.get(i);
        return res;
    }

    private void recur(ListNode node) {
        if (node == null) return;
        recur(node.next);
        arr.add(node.val);
    }

    /**
     * 栈
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while (p != null) {
            s.push(p.val);
            p = p.next;
        }
        int n = s.size();
        int[] res = new int[n];
        n = 0;
        while (s.size() > 0) {
            res[n++] = s.pop();
        }
        return res;
    }



}
