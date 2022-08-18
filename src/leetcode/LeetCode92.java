package leetcode;

// FAIL
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }

        ListNode headTail = new ListNode(0, head);

        for (int i = 0; i < m - 1; i++) {
            headTail = headTail.next;
        }


        ListNode curr = headTail;
        ListNode pre = headTail.next;

        ListNode dummy = new ListNode(0);
        ListNode dummy2 = dummy;

        for (int i = m; i <= n; i++) {

            curr = pre;
            pre = pre.next;


            curr.next = dummy;
            dummy = curr;

        }

        if (m == 1) {
            ListNode a = dummy;
            ListNode b = a;

            while (b.next.val != 0) {
                b = b.next;
            }

            if (pre == null) {
                b.next = null;
            } else {
                b.next = pre;
            }


            while (a != null) {
                System.out.println(a.val);
                a = a.next;
            }


            return a;
        }


        dummy2.next = pre;
        headTail.next = dummy;


        ListNode a = head;

        while (a.next.val != 0) {
            a = a.next;
        }

        a.next = pre;

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        return head;
    }
}
