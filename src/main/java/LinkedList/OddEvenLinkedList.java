package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 20/05/23, Saturday
 **/
public class OddEvenLinkedList {


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

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode oddH = head;
            ListNode evenH = head.next;

            ListNode oddTail = oddH;
            ListNode evenTail = evenH;
            ListNode temp = head.next.next;

            oddH.next = null;
            evenH.next = null;

            int counter = 1;
            while (temp != null) {
                ListNode next = temp.next;

                temp.next = null;
                if (counter % 2 == 1) {
                    oddTail.next = temp;
                    oddTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }

                counter++;
                temp = next;
            }

            oddTail.next = evenH;
            return oddH;
        }
    }
}
