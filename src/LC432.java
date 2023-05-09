import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC432 {
    class Bucket {
        int count;
        Set<String> set;
        Bucket prev;
        Bucket next;


        public Bucket(int count) {
            this.count = count;
            this.set = new HashSet<>();
            this.prev = null;
            this.next = null;
        }
    }


    private HashMap<String, Bucket> map;

    private Bucket head;
    private Bucket tail;


    public LC432() {
        map = new HashMap<>();
        head = new Bucket(0);
        tail = new Bucket(-1);
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
    }

    public void inc(String key) {
        Bucket bucket = map.get(key);
        if (bucket == null) { // not exist
            map.put(key, head);
            head.set.add(key);
            bucket = head;
        }

        if (bucket.next.count != bucket.count + 1) { // +1 bucket not exist
            Bucket nxtBucket = new Bucket(bucket.count + 1);
            nxtBucket.set.add(key);
            addToPrev(bucket, nxtBucket);
        } else {
            bucket.next.set.add(key);
        }
        bucket.set.remove(key);
        map.put(key, bucket.next);


        if (bucket != head && bucket.set.isEmpty()) {
            removeBucket(bucket);
        }

    }

    public void dec(String key) {
        Bucket bucket = map.get(key);
        if (bucket.count == 1) {
            map.remove(key);
        } else if (bucket.prev.count != bucket.count - 1) {// -1 bucket not exist
            Bucket preBucket = new Bucket(bucket.count - 1);
            preBucket.set.add(key);
            addToPrev(bucket.prev, preBucket);
        } else {
            bucket.prev.set.add(key);
        }

        bucket.set.remove(key);
        if (bucket.count != 1) {
            map.put(key, bucket.prev);
        }

        if (bucket.set.isEmpty()) {
            removeBucket(bucket);
        }
    }

    public String getMaxKey() {
        if (head.next == tail) {
            return "";
        }


        return tail.prev.set.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.set.iterator().next();
    }


    private void removeBucket(Bucket cur) {
        Bucket prevNode = cur.prev;
        Bucket nextNode = cur.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    private void addToPrev(Bucket pre, Bucket node) {
        node.next = pre.next;
        node.prev = pre;


        pre.next.prev = node;
        pre.next = node;
    }

    public static void main(String[] args) {
        LC432 lc432 = new LC432();

        lc432.inc("a");
        lc432.inc("b");
        lc432.inc("b");
        lc432.inc("c");
        lc432.inc("c");
        lc432.inc("c");
        lc432.dec("b");
        lc432.dec("b");

        System.out.println(lc432.getMaxKey());
        System.out.println(lc432.getMinKey());
        lc432.dec("a");
        //System.out.println(lc432.getMaxKey());
        System.out.println(lc432.getMinKey());
    }
}
