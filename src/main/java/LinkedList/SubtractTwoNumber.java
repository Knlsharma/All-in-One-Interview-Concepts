package LinkedList;

/**
 * @author : Kunal Sharma
 * @since : 21/05/23, Sunday
 **/
public class SubtractTwoNumber {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static int getSize(Node node){
        int sz = 0;

        while(node != null){
            node = node.next;
            sz++;
        }

        return sz;
    }

    static Node padWithZeroes(Node node, int pad){
        for(int i = 1; i <= pad; i++){
            Node temp = new Node(0);
            temp.next = node;
            node = temp;
        }

        return node;
    }

    static Node stripLeadingZeroes(Node node){
        while(node != null){
            if(node.data == 0){
                node = node.next;
            } else {
                break;
            }
        }

        if(node != null){
            return node;
        } else {
            return new Node(0);
        }
    }

    Node subLinkedList(Node l1, Node l2)
    {
        l1 = stripLeadingZeroes(l1);
        l2 = stripLeadingZeroes(l2);

        int s1 = getSize(l1);
        int s2 = getSize(l2);

        Node shead = l1;
        Node lhead = l2;

        if(s1 < s2){
            shead = l1;
            lhead = l2;

            shead = padWithZeroes(shead, s2 - s1);
        } else if(s1 > s2){
            shead = l2;
            lhead = l1;

            shead = padWithZeroes(shead, s1 - s2);
        } else {
            Node t1 = l1;
            Node t2 = l2;

            while(t1 != null){
                if(t1.data < t2.data){
                    shead = l1;
                    lhead = l2;
                    break;
                } else if(t1.data > t2.data) {
                    shead = l2;
                    lhead = l1;
                    break;
                }

                t1 = t1.next;
                t2 = t2.next;
            }
        }

        borrow = false;
        Node node = helper(lhead, shead);
        return stripLeadingZeroes(node);
    }

    static boolean borrow = false;
    Node helper(Node n1, Node n2){
        if(n1 == null){
            return null;
        }

        Node next = helper(n1.next, n2.next);

        int d1 = n1.data;
        int d2 = n2.data;

        if(borrow){
            d1--;
            borrow = false;
        }

        if(d1 < d2){
            borrow = true;
            d1 += 10;
        }

        int d = d1 - d2;
        Node node = new Node(d);
        node.next = next;

        return node;
    }
}
