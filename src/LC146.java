import java.util.HashMap;

public class LC146 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LC146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // dummy head
        this.tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node cur = map.get(key);
        if (cur == null) {
            return -1;
        }

        addToHead(cur);

        return cur.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            addToHead(node);
            return;
        }

        if (map.size() >= capacity) {
            map.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }

        Node cur = new Node(key, value);
        map.put(key, cur);
        addToHead(cur);
    }

    private void addToHead(Node node) {
        if (node.prev != null || node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LC146 lc146 = new LC146(2);

//        lc146.put(1, 1);
//        lc146.put(2, 2);
//        System.out.println(lc146.get(1));
//        lc146.put(3, 3);
//        System.out.println(lc146.get(2));
//        lc146.put(4, 4);
//        System.out.println(lc146.get(1));
//        System.out.println(lc146.get(3));
//        System.out.println(lc146.get(4));

        lc146.put(2, 1);
        lc146.put(1, 1);
        lc146.put(2, 3);
        lc146.put(4, 4);
        System.out.println(lc146.get(1));
        System.out.println(lc146.get(2));

    }
}
