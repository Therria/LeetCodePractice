import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LC380 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> array;

    public LC380() {
        this.map = new HashMap<>();
        this.array = new ArrayList<>();
    }

    public boolean insert(int val) {
        Integer idx = map.get(val);
        if (idx != null) {
            return false;
        }
        array.add(val);
        map.put(val, array.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        Integer idx = map.get(val);
        if (idx == null) {
            return false;
        }
        int size = array.size();
        map.put(array.get(size - 1), idx);
        map.remove(val);
        array.set(idx, array.get(size - 1));
        array.remove(size - 1);
        return true;
    }

    public int getRandom() {
        return array.get(new Random().nextInt(array.size()));
    }

    public static void main(String[] args) {
        LC380 lc380 = new LC380();

        System.out.println(lc380.remove(0));
        System.out.println(lc380.remove(0));
        System.out.println(lc380.insert(0));
        System.out.println(lc380.getRandom());
        System.out.println(lc380.remove(0));
        System.out.println(lc380.insert(0));
    }
}
