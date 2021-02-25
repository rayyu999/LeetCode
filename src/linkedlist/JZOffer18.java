package linkedlist;

import datastructure.ListNode;

public class JZOffer18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        dummyHead.next = head;
        while (p.next != null && p.next.val != val) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        return dummyHead.next;
    }

}
