package linkedlist;

import datastructure.ListNode;

public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q =l2, pre = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int z = x + y + carry;
            pre.next = new ListNode(z % 10);
            pre = pre.next;
            carry = z / 10;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
