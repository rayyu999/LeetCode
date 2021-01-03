package linkedlist;

import datastructure.ListNode;

public class No86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(), dummyHead2 = new ListNode();
        ListNode cur1 = dummyHead1, cur2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                cur2.next = head;
                head = head.next;
                cur2 = cur2.next;
                cur2.next = null;
            } else {
                cur1.next = head;
                head = head.next;
                cur1 = cur1.next;
                cur1.next = null;
            }
        }
        cur2.next = dummyHead1.next;
        return dummyHead2.next;
    }

}
