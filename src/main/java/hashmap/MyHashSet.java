package hashmap;

public class MyHashSet {

    // hashFunction: y = key%cap
    Integer[] keys;
    int cap = 10;
    int count =0;

    public MyHashSet() {
        keys = new Integer[cap];
    }

    public void add(int key) {
        // Use hash function to get position
        int pos = hashFunction(key);
        if (contains(key)) {
            System.out.println("key exist: " + key);
            return;
        }

        // increase cap & rehash if position is already used
        while (keys[pos] != null && keys[pos]!=key) {
            reHash();
            pos = hashFunction(key);
        }

        if (keys[pos] == null) {
            keys[pos] = key;
            count++;
        }
    }

    public void remove(int key) {
        int pos = hashFunction(key);

        if (keys[pos] != null && keys[pos] == key) {
            keys[pos] = null;
            count--;
        }
    }

    public boolean contains(int key) {
        int pos = hashFunction(key);
        return keys[pos] != null && keys[pos] == key;

    }

    private int hashFunction(int key) {
        int hash = key % cap;
        if(hash<0) {
            return hash + cap;
        }
        return hash;
    }

    private void reHash() {
        Integer[] oldKeys = keys;
        cap=2*cap;
        keys =new Integer[cap];
        for(Integer key: oldKeys) {
            if(key != null) {
                int pos = hashFunction(key);
                keys[pos] = key;
            }
        }
    }

    public void printContent() {
        System.out.println("-------------------------------");
        System.out.println("MyHashSetV2 values");
        for (Integer value : keys) {
            if (value != null) {
                System.out.println(value);
            }
        }
        System.out.println("Number of elements: " + size());
    }

    public int size() {
        return count;
    }
}
