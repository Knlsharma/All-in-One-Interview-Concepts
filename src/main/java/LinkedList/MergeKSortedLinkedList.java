package LinkedList;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 13/07/24, Saturday
 **/
//T.C. : O(NlogK)
//S.C. : O(logK)
public class MergeKSortedLinkedList {

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

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) { // O(M)
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode partitionAndMerge(int start, int end, List<ListNode> lists) {
        if (start == end)
            return lists.get(start);

        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        ListNode l1 = partitionAndMerge(start, mid, lists);  // O( Log n)
        ListNode l2 = partitionAndMerge(mid + 1, end, lists); // O( Log n)

        return mergeTwoSortedLists(l1, l2);
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        int n = lists.size();

        if (n == 0)
            return null;

        return partitionAndMerge(0, n - 1, lists);
    }
}
