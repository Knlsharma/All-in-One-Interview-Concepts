package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 12/07/24, Friday
 **/


public class DeleteMiddleNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return head.next; // No nodes or only one node, return head as it is
        }

        // without using prev
        // already made a increase other can start both from head
        ListNode sp = head;
        ListNode fp = head.next.next;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        sp.next = sp.next.next;
        return head;
    }
}
