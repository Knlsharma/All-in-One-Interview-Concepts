package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 20/05/23, Saturday
 **/
public class ReorderList {

    //  also called fold a linked list
    // can also be done by iterative

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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        left = head;
        helper(head);
    }

    ListNode left;
    boolean work = true;

    void helper(ListNode right) {
        if (right == null) {
            return;
        }

        helper(right.next);

        if (work == true && (left == right || left.next == right)) {
            right.next = null;
            work = false;
        } else if (work == true) {
            ListNode temp = left.next;

            left.next = right;
            right.next = temp;

            left = temp;
        }
    }

}
