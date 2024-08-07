package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 19/07/24, Friday
 **/
public class SplitLinkedList {

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

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int L = 0;
        while (curr != null) {
            L++;
            curr = curr.next;
        }

        int eachBucketNodes = L / k;
        int remainderNodes = L % k;

        ListNode[] result = new ListNode[k];
        curr = head;
        ListNode prev = null;

        for (int i = 0; curr != null && i < k; i++) {
            result[i] = curr;

            for (int count = 1; count <= eachBucketNodes + (remainderNodes > 0 ? 1 : 0); count++) {
                prev = curr;
                curr = curr.next;
            }

            if (prev != null) {
                prev.next = null;
            }

            remainderNodes--;
        }

        return result;

    }
}
