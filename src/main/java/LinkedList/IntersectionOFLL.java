package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 21/05/23, Sunday
 **/
public class IntersectionOFLL {

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


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sa = getSize(headA);
        int sb = getSize(headB);
        int gap = sa - sb;

        if(gap >= 0){
            for(int i = 0; i < gap; i++){
                headA = headA.next;
            }
        } else {
            gap = Math.abs(gap);
            for(int i = 0; i < gap; i++){
                headB = headB.next;
            }
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    int getSize(ListNode temp){
        int sz = 0;

        while(temp != null){
            sz++;
            temp = temp.next;
        }

        return sz;
    }
}
