//package NextLevel;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * @author Kunal Sharma at 10/04/22 1:28 PM
// */
//public class LRU {
//
//    static class Node {
//        int key;
//        int val;
//
//        public Node(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    // least recently used
//    // Old wala delete hoga
//
//    LinkedList<Node> list = new LinkedList(3);
//
//    Map<Integer, Node> map = new HashMap<>();
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            list.remove(node);
//            list.addFirst(node);
//            map.put(key, node);
//            return node.val;
//        } else {
//            return -1;
//        }
//    }
//
//
//    public void put(int key, int val)
//    {
//        Node node = new Node(key, val);
//        if(map.containsKey(key))
//        {
//            node = map.get(key);
//            list.remove(node);
//        }
//        else if(list.size() == 3)
//        {
//            map.remove(key);
//            list.removeLast();
//        }
//        else if(list.size() < 3)
//        {
//
//        }
//        list.addFirst(node);
//        map.put(key,node);
//    }
//
//
//}
