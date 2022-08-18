package leetcode;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 어려웠던 점 : String형식으로 덧셈을 구현하는 것이 귀찮았음
        // 생각보다 오래 걸려서 자존심 상함

        String one = "";
        String two = "";


        while (l1 != null) {

            one = l1.val + one;
            l1 = l1.next;
        }

        while (l2 != null) {

            two = l2.val + two;
            l2 = l2.next;
        }

        int i = one.length();
        int j = two.length();
        int temp = 0;
        String result = "";

        while (true) {
            int a = 0;
            int b = 0;
            if (i > 0) {
                a = Integer.parseInt(one.substring(i - 1, i));
            }
            if (j > 0) {
                b = Integer.parseInt(two.substring(j - 1, j));
            }
            int output = a + b + temp;
            int f = (output) % 10;
            temp = output / 10;


            result = f + result;


            i--;
            j--;

            if (i < 0 && j < 0) {
                break;
            }
        }


        if (result.charAt(0) == '0') {
            result = result.substring(1, result.length());
        }
        System.out.println(result);
        ListNode answer = new ListNode(Integer.parseInt(result.substring(result.length() - 1, result.length())));
        ListNode cur = answer;

        for (int k = result.length() - 1; k >= 1; k--) {
            ListNode tempL = new ListNode(Integer.parseInt(result.substring(k - 1, k)));
            cur.next = tempL;
            cur = cur.next;
        }


        return answer;
    }

}
