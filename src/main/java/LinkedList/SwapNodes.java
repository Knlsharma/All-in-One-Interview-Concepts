package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 17/07/24, Wednesday
 **/
public class SwapNodes {

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

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next; // storing 2
        head.next = swapPairs(head.next.next); // will reverse 3 and 4 and will catch in 1
        temp.next = head; // linking 2 --> 1
        return temp; // returning 2

    }
}
