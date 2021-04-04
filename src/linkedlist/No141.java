package linkedlist;

import datastructure.ListNode;

public class No141 {

    public boolean hasCycle(ListNode head) {
        if (head != null && head.next != null) {
            ListNode fast = head.next, slow = head;
            while (fast != null && slow != null) {
                if (fast == slow) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
            }
        }
        return false;
    }

}
