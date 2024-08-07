package LinkedList;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 21/05/23, Sunday
 **/
public class AddTwoNumber {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Approach 2

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode prev = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            ListNode res = new ListNode();

            res.val = carry;
            if (l1 != null) {
                res.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                res.val += l2.val;
                l2 = l2.next;
            }

            carry = res.val / 10;
            res.val = res.val % 10;

            if (head == null) {
                head = res;
                prev = res;
            } else {
                prev.next = res;
                prev = res;
            }
        }

        return head;

    }

    public ListNode addTwoNumbersViaStack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Push values of l1 into stack s1
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        // Push values of l2 into stack s2
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0, carry = 0;
        ListNode ans = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            sum = carry;

            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = ans;
            ans = newNode;

            carry = sum / 10;
        }

        return ans;

    }
}
