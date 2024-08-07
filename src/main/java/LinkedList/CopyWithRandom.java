package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 25/03/24, Monday
 **/


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyWithRandom {

    // Using extra space
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node curr = head;
        Node nhead = new Node(-1);
        Node prev = nhead;
        while (curr != null)
        {
            Node node = new Node(curr.val);
            prev.next = node;
            map.put(curr, node);

            prev = prev.next;
            curr = curr.next;
        }

        nhead = nhead.next;
        Node c1 = head;
        Node c2 = nhead;

        while(c1 != null)
        {
            c2.random = c1.random != null ? map.get(c1.random) : null;

            c1 = c1.next;
            c2 = c2.next;

        }

        return nhead;
    }

    // without using space


    // approach 2
    public Node copyRandomList2(Node head)
    {
        copyRandomListWithoutSpace(head);
        updatePointer(head);
        return extractListNode(head);
    }
    public void copyRandomListWithoutSpace(Node head)
    {
        // insert node after
        Node curr = head;
        while (curr != null)
        {
            Node forward = curr.next;
            Node node = new Node(curr.val);
            curr.next = forward;
            node.next = node;

            curr = forward;
        }


    }

    public void updatePointer(Node head)
    {
        Node cur = head;
        while(cur != null)
        {
            Node randomNode = cur.random;
            if(randomNode != null)
            {
                cur.next.random = randomNode.next;
            }
        }
        cur = cur.next.next;
    }

    public Node extractListNode(Node head)
    {
        Node dnode = new Node(-1);
        Node prev = dnode, cur = head;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;

            prev = prev.next;
            cur = cur.next;
        }

        return dnode.next;
    }


}
