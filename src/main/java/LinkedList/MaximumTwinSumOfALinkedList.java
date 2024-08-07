package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 17/07/24, Wednesday
 **/
public class MaximumTwinSumOfALinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int pairSum(ListNode head) {
        ListNode mid = null;

        ListNode slow = head;
        ListNode fast = head;

        // Finding the middle of the linked list using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;

        // Reversing the second half of the linked list
        ListNode prev = null;
        ListNode nextNode = null;
        while (mid != null) {
            nextNode = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nextNode;
        }

        // `prev` now points to the head of the reversed second half

        ListNode curr = head;
        int result = 0;

        // Calculating maximum pair sum
        while (prev != null) {
            result = Math.max(result, curr.val + prev.val);
            curr = curr.next;
            prev = prev.next;
        }

        return result;
    }



}
