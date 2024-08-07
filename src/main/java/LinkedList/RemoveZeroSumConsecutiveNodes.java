package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 17/07/24, Wednesday
 **/
//T.C : O(n^2)
//S.C : O(n) - We took a map
public class RemoveZeroSumConsecutiveNodes {

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

    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy);

        while (head != null) {
            prefixSum += head.val;

            if (map.containsKey(prefixSum)) {
                ListNode oldNodeSeen = map.get(prefixSum);
                ListNode start = oldNodeSeen;
                int pSum = prefixSum;

                while (start != head) {
                    start = start.next;
                    pSum += start.val;
                    if (start != head) {
                        map.remove(pSum);
                    }
                }

                oldNodeSeen.next = start.next;

            }
            else {
                map.put(prefixSum, head);
            }

            head = head.next;
        }

        return dummy.next;
    }
}
