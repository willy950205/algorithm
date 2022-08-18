package leetcode;


public class Main {
    public static void main(String[] args) {

        ListNode head = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode head2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//		ListNode head  = new ListNode(2, new ListNode(4, new ListNode(3)));
//		ListNode head2  = new ListNode(5, new ListNode(6, new ListNode(4)));
        Leetcode2 a = new Leetcode2();
        a.addTwoNumbers(head, head2);


    }
}
