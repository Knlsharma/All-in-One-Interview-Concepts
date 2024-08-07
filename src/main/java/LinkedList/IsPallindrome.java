package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 20/07/24, Saturday
 **/
public class IsPallindrome {

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

    public boolean isPalindromeUsingFirstHalfReverse(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // To handle case when number of nodes is odd
        if (fast != null)
            slow = slow.next;

        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false;
            }

            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }


    // Using recursion
    ListNode curr;

    public boolean solve(ListNode head) {
        if (head == null)
            return true;

        if (!solve(head.next) || head.val != curr.val) {
            return false;
        }

        curr = curr.next;
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        curr = head;

        return solve(head);
    }
}
